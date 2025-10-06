package com.rpg.combate;
import com.rpg.personagens.InterfaceCombatente;
import com.rpg.personagens.MonstroAbstrato;
import java.util.Random;

/**
 * Classe que implementa InterfaceAcaoDeCombate, representando a ação de combate
 * de um monstro qualquer, quando utiliza seu ataque simples.
 * 
 * @author : Agnes Manoel e Bernardo Nascimento
 */
public class AtaqueMonstroSimples implements InterfaceAcaoDeCombate {

    /**
     * Método que implementa o ataque simples de um monstro. O usuário 
     * possui 75% de chance de acerto.
     */
    public void executar(InterfaceCombatente usuario, InterfaceCombatente alvo) {
        MonstroAbstrato monstro = (MonstroAbstrato) usuario;

        int dano;
        Random random = new Random();
        int numAleat = random.nextInt(0,100);

        if (numAleat<75) { // definir melhor aqui o numAleat
            dano = monstro.getForca() + monstro.getDanoArma();
            alvo.receberDano(dano);

            System.out.println(monstro.getNome() + ": *** ACERTOU O ATAQUE : " + dano + " Dano ***"); 
            if (alvo.getPontosDeVida() <= 0) {System.out.println(monstro.fraseDeEfeito);}
            else {System.out.println(monstro.getFraseVitoria());}
            
        }

        else {System.out.println(monstro.getNome() + ": *** ERROU O ATAQUE ***"); }
    }
        
    }
    
