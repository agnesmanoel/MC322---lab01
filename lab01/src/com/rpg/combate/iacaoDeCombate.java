package com.rpg.combate;

import com.rpg.exception.HabilidadeAntesdeVidaSuficiente;
import com.rpg.personagens.iCombatente;

public interface iacaoDeCombate {
    void executar(iCombatente usuario, iCombatente alvo) throws HabilidadeAntesdeVidaSuficiente;
}
