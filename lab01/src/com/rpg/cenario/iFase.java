package com.rpg.cenario;
import com.rpg.personagens.HeroiAbstrato;

public interface iFase {
    void iniciar(HeroiAbstrato heroi);
    boolean isConcluida();
    String getTipoDeCenario();

}
