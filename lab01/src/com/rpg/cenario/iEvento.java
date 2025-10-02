package com.rpg.cenario;
import com.rpg.personagens.HeroiAbstrato;

public interface iEvento {
    boolean verificarGatilho(HeroiAbstrato usuario);
    void executar(HeroiAbstrato usuario);
}
