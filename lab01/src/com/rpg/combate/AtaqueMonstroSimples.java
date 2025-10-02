package com.rpg.combate;
import com.rpg.personagens.InterfaceCombatente;
import com.rpg.personagens.MonstroAbstrato;
import java.util.Random;

public class AtaqueMonstroSimples implements InterfaceAcaoDeCombate {

    // Método de ataque simples dos monstros.
    public void executar(InterfaceCombatente usuario, InterfaceCombatente alvo) {
        MonstroAbstrato monstro = (MonstroAbstrato) usuario;

        int dano;
        Random random = new Random();
        int numAleat = random.nextInt(0,100);

        if (numAleat<75) { // definir melhor aqui o numAleat
            dano = monstro.forca + monstro.arma.dano;
            alvo.receberDano(dano);

            System.out.println(monstro.nome + ": *** ACERTOU O ATAQUE : " + dano + " Dano ***"); 
            if (alvo.estaVivo()) {System.out.println(monstro.fraseDeEfeito);}
            else {System.out.println(monstro.fraseVitoria);}
            
        }

        else {System.out.println(monstro.nome + ": *** ERROU O ATAQUE ***"); }
    }
        
    }
    
