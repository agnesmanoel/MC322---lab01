package com.rpg.personagens;
import com.rpg.combate.InterfaceAcaoDeCombate;

public interface InterfaceCombatente {

    String getNome();
    int getPontosDeVida();
    boolean estaVivo();
    void receberDano(int dano);
    void receberCura(int cura);
    InterfaceAcaoDeCombate escolherAcao(InterfaceCombatente alvo);


}
