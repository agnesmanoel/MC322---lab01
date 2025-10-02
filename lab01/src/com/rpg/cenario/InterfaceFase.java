package com.rpg.cenario;
import com.rpg.personagens.HeroiAbstrato;

public interface InterfaceFase {
    void iniciar(HeroiAbstrato heroi);
    boolean isConcluida();
    String getTipoDeCenario();

}
