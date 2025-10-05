package com.rpg.cenario;
import com.rpg.personagens.HeroiAbstrato;

/**
 * Classe Enum para todos os cenários da campanha.
 * 
 * @author : Agnes Manoel e Bernardo Nascimento
 */
public enum TipoDeCenario {

    PORTÃO ("Os portões do reino são assolados por multidões de monstros..."),
    CORREDORES ("As trevas destes, há muito esquecidos, corredores encaminham o aventureiro rumo à Antiga Masmorra..."),
    MASMORRA ("A Antiga Masmorra regojiza-se pela volta de banhos de sangue - inocente e assassínio!");

    private final String descricao;

    /**
     * Método construtor do tipo de cenário.
     * 
     * @param descricao : descrição do cenário (String).
     */
    private TipoDeCenario(String descricao) {
        this.descricao = descricao;
    }

    /**
     * Pequena introdução, e ambientação dos cenários.
     */
    void aplicarEfeitos(HeroiAbstrato heroi) {
        System.out.println(descricao + "\n" + heroi.getNome() + " avança, inquebrantável, sem medo.");
    }
    
}
