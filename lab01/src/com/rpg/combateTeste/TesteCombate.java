package com.rpg.combateTeste; 
import com.rpg.*;
import com.rpg.combate.AtaqueHeroiSimples;
import com.rpg.combate.AtaqueMonstroSimples;
import com.rpg.combate.InterfaceAcaoDeCombate;
import com.rpg.exception.HabilidadeAntesdeVidaSuficiente;
import com.rpg.itens.Pedra;
import com.rpg.itens.Arma;
import com.rpg.itens.Coroa;
import com.rpg.itens.InterfaceLootavel;
import com.rpg.personagens.Esqueleto;
import com.rpg.personagens.Fantasma;
import com.rpg.personagens.Feiticeira;
import com.rpg.personagens.InterfaceCombatente;
import com.rpg.personagens.MonarcaEsqueleto;
import com.rpg.personagens.Paladino;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

import org.junit.Test;
import org.junit.jupiter.api.AfterEach;


public class TesteCombate {

    Paladino paladino = new Paladino();
    Feiticeira feiticeira = new Feiticeira();

    Arma[] list = {new Pedra(), new Coroa()};
    Esqueleto esqueleto = new Esqueleto(0, 0, list);
    Fantasma fantasma = new Fantasma(0, 0, list);
    MonarcaEsqueleto monarca = new MonarcaEsqueleto(0, 0, list);

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();


    @Test
    public void testInterface() {

        assertEquals(true, esqueleto instanceof InterfaceCombatente);
        assertEquals(true, fantasma instanceof InterfaceCombatente);
        assertEquals(true, monarca instanceof InterfaceCombatente);
        assertEquals(true, paladino instanceof InterfaceCombatente);
        assertEquals(true, feiticeira instanceof InterfaceCombatente);

    }

    @Test
    public void testAtaqueDanoHeroi() throws HabilidadeAntesdeVidaSuficiente {

        InterfaceAcaoDeCombate ataqueHeroi = new AtaqueHeroiSimples();
        ataqueHeroi.executar(feiticeira, esqueleto);
        boolean flag = "".equals(outContent.toString());
        assertEquals(true, flag);

        int vidaInicial = paladino.getPontosDeVida();
        paladino.receberDano(1);
        assertEquals(true, vidaInicial>paladino.getPontosDeVida());

    }

    @Test
    public void testAtaqueDanoMonstro() throws HabilidadeAntesdeVidaSuficiente {

        InterfaceAcaoDeCombate ataqueMonstro = new AtaqueMonstroSimples();
        ataqueMonstro.executar(monarca, paladino);
        boolean flag = "".equals(outContent.toString());
        assertEquals(true, flag);

        int vidaInicial = monarca.getPontosDeVida();
        paladino.receberDano(1);
        assertEquals(true, vidaInicial<paladino.getPontosDeVida());

    }

    @Test
    public void testLootavel () {
    
        assertEquals(true, esqueleto instanceof InterfaceLootavel);
        assertEquals(true, fantasma instanceof InterfaceCombatente);
        assertEquals(true, monarca instanceof InterfaceCombatente);
        
    }
    
}