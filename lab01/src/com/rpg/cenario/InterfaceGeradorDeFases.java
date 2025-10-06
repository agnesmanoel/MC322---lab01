package com.rpg.cenario;

/**
 * Interface para todos os geradores de fases do jogo.
 * 
 * @author : Agnes Manoel e Bernardo Nascimento
 */
public interface InterfaceGeradorDeFases {

    /**
     * Método que gera fases de combate do jogo.
     * 
     * @param quantidadeDeFases : número de fases a serem geradas (int);
     * @param dificuldade : dificuldade das fases (Dificuldade);
     * @return : lista de fases geradas (FaseCombate[]).
     */
    FaseCombate[] gerar(int quantidadeDeFases, Dificuldade dificuldade);
}
