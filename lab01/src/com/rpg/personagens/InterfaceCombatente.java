package com.rpg.personagens;
import com.rpg.combate.InterfaceAcaoDeCombate;

/**
 * Interface para todos os combatentes do jogo, sejam herói ou monstro.
 * 
 * @author : Agnes Manoel e Bernardo Nascimento
 */
public interface InterfaceCombatente {

    String getNome();
    int getPontosDeVida();
    boolean estaVivo();
    void receberDano(int dano);
    void receberCura(int cura);
    InterfaceAcaoDeCombate escolherAcao(InterfaceCombatente alvo);


}
