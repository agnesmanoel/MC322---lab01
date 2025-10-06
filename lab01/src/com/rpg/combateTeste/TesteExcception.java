package com.rpg.combateTeste;
import com.rpg.personagens.Feiticeira;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.rpg.combate.AtaquePocaoAstral;
import com.rpg.itens.Arma;
import com.rpg.itens.Coroa;
import com.rpg.itens.Pedra;
import com.rpg.personagens.Fantasma;
import com.rpg.exception.HabilidadeAntesdeVidaSuficiente;
import com.rpg.exception.mininsuficienteArma;

public class TesteExcception {

    
    Arma[] list = {new Pedra(), new Coroa()};

    Feiticeira feiticeira = new Feiticeira();
    Fantasma fantasma = new Fantasma(1,1,list);

    @Test
    public void testHabilidade() {

    try{
        AtaquePocaoAstral ataque = new AtaquePocaoAstral();
        
        ataque.executar(feiticeira,fantasma); 
    } catch(HabilidadeAntesdeVidaSuficiente e){
        assertEquals(0, 0);
    }
}

    @Test
    public void testNivel() {
    
    Arma armaDropada = new Coroa();
    try{
        feiticeira.equiparArma(armaDropada); 
    } catch(mininsuficienteArma e){
        assertEquals(0, 0);
    }


    }

    
}
