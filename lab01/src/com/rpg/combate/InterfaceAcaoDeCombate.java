package com.rpg.combate;

import com.rpg.exception.HabilidadeAntesdeVidaSuficiente;
import com.rpg.personagens.InterfaceCombatente;

public interface InterfaceAcaoDeCombate {
    void executar(InterfaceCombatente usuario, InterfaceCombatente alvo) throws HabilidadeAntesdeVidaSuficiente;
}
