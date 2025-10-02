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
            dano = monstro.getForca() + monstro.arma.dano;
            alvo.receberDano(dano);

            System.out.println(monstro.getNome() + ": *** ACERTOU O ATAQUE : " + dano + " Dano ***"); 
            if (alvo.getPontosDeVida() <= 0) {System.out.println(monstro.fraseDeEfeito);}
            else {System.out.println(monstro.getFraseVitoria());}
            
        }

        else {System.out.println(monstro.getNome() + ": *** ERROU O ATAQUE ***"); }
    }
        
    }
    
