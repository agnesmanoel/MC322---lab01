package com.rpg.combate;

import com.rpg.exception.HabilidadeAntesdeVidaSuficiente;
import com.rpg.personagens.InterfaceCombatente;

/**
 * Interface para todas as ações de combate entre dois combatentes.
 * 
 * @author : Agnes Manoel e Bernardo Nascimento
 */
public interface InterfaceAcaoDeCombate {

    /**
     * Método que executa a ação de combate.
     * 
     * @param usuario : combatente que executa a ação;
     * @param alvo : combatente que sofre a ação.
     * @throws HabilidadeAntesdeVidaSuficiente
     */
    void executar(InterfaceCombatente usuario, InterfaceCombatente alvo) throws HabilidadeAntesdeVidaSuficiente;
}
