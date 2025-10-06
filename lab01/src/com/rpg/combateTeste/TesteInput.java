package com.rpg.combateTeste;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;
import java.lang.reflect.Field;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import com.rpg.combate.AtaquePocaoAstral;
import com.rpg.itens.Arma;
import com.rpg.itens.Coroa;
import com.rpg.itens.Pedra;
import com.rpg.personagens.Fantasma;
import com.rpg.util.InputManager;
import com.rpg.exception.HabilidadeAntesdeVidaSuficiente;
import com.rpg.exception.mininsuficienteArma;


public class TesteInput {
    
    private final InputStream systemInOriginal = System.in;
    private final PrintStream systemOutOriginal = System.out;
    private ByteArrayOutputStream systemOutContent;

    @BeforeEach
    @Before
    public void setUpStreams() {
        systemOutContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(systemOutContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setIn(systemInOriginal);
        System.setOut(systemOutOriginal);
    }

    private void provideInput(String data) throws Exception {
        ByteArrayInputStream testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);

        Field scannerField = InputManager.class.getDeclaredField("scanner");
        scannerField.setAccessible(true);
        scannerField.set(null, new Scanner(testIn));
    }


    @Test
    public void deveTratarInputInteiroComoInvalido() throws Exception {
        String inputSequencia = "123\ns\n";
        provideInput(inputSequencia);

        assertTrue(InputManager.lerSimNao(""));

        String output = systemOutContent.toString();
        assertTrue(output.contains("<Entrada inválida. Digite s ou n.>"));


    }


    @Test
    public void deveTratarInputInteiroSemEntrada() throws Exception {
        String inputSequencia = "\n";
        provideInput(inputSequencia);

        assertTrue(InputManager.lerSimNao(""));

        RuntimeException exception = assertThrows(RuntimeException.class, () -> InputManager.lerInteiro("Digite um numero", 1, 10));
        String output = systemOutContent.toString();
        assertTrue(output.contains("<Entrada vazia>"));


    }
}
