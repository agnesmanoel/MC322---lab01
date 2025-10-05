package com.rpg.itens;

/**
 * Classe abstrata para todas as armas do jogo, implementa InterfaceItem.
 * 
 * @author : Agnes Manoel e Bernardo Nascimento
 */
abstract public class Arma implements InterfaceItem {

    protected String nome;
    public  int dano;
    public  int minNivel;
    public  String intro;

    /** 
     * Método construtor de Arma. São passados nome, dano, nível mínimo para uso e 
     * texto de introdução.
     */
    public Arma(String nome, int d, int n, String txt) {
        this.nome = nome;
        this.dano = d;
        this.minNivel = n;
        this.intro = txt;
    }

    /**
     * Método getter para retornar o nome da arma.
     */
    public String getNome() {
        return this.nome;
    }

    /**
     * Método getter para retornar o dano da arma.
     */
    public int getDano() {
        return this.dano;
    }
    
}
