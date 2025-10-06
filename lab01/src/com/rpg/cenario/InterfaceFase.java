package com.rpg.cenario;
import com.rpg.personagens.HeroiAbstrato;

/**
 * Interface básica para todas as fases do jogo.
 * 
 * @author : Agnes Manoel e Bernardo Nascimento
 */
public interface InterfaceFase {
    void iniciar(HeroiAbstrato heroi);
    boolean isConcluida();
    String getTipoDeCenario();

}
