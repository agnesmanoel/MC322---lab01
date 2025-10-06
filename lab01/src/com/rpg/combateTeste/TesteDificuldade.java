package com.rpg.combateTeste;

import com.rpg.*;
import com.rpg.cenario.Dificuldade;
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

public class TesteDificuldade {

    Dificuldade facil = Dificuldade.FACIL;
    Dificuldade normal = Dificuldade.NORMAL;

    @Test
    public void testDiferencas () {

        assertEquals(true, facil.AdicionalForca()<normal.AdicionalForca());
        assertEquals(true, facil.AdicionalVida()<normal.AdicionalVida());
    }
    
}
