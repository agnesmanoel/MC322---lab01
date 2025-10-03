package com.rpg.personagens;
import com.rpg.itens.Arma;
import com.rpg.itens.InterfaceItem;
import com.rpg.itens.InterfaceLootavel;
import java.util.Random;

public abstract class MonstroAbstrato extends PersonagemAbstrato implements InterfaceLootavel{
    
    public int xpConcedido;
    public String fraseDeEfeito;
    public String fraseVitoria;
    protected String fraseApresentacao; 
    protected String imageURL;
    protected Arma listaDeArmasParaLargar[];

    /**
     * Método construtor, o qual aplica super() para inicializar componentes de PersonagemAbstrato.
     * @param n : nome;
     * @param pv : vida;
     * @param f : força;
     * @param xp : experiência concedida ao herói;
     * @param fraseEfeito : texto para frase dita quando se ataca inimigo;
     * @param fraseVitoria : texto para frase dita quando se derrota oponente;
     * @param fraseApresentacao : texto de apresentação do monstro;
     * @param imageURL : imagem ASCII do personagem.
     * @param arma : arma do personagem;
     * @param descr : descrição do monstro.
     */
    public MonstroAbstrato(String n, int pv, int f, int xp, String fraseEfeito, String fraseVitoria, String fraseApresentacao, String URL, Arma arma, String descr, int adVida, int adForca) {
        super(n, pv+adVida, f+adForca, URL, arma, descr);
        this.xpConcedido = xp;
        this.fraseDeEfeito = fraseEfeito;
        this.fraseVitoria = fraseVitoria;
        this.fraseApresentacao = fraseApresentacao;
        this.listaDeArmasParaLargar = new Arma[3]; 
    }

    public int getXpConcedido() {
        return this.xpConcedido;
    }

    public String getFraseEfeito() {
        return this.fraseDeEfeito;
    }
    
    public String getFraseVitoria() {
        return this.fraseVitoria;
    }
    
    /**
     * Método de conversão do objeto em string a partir de overide sobre toString() e chamada 
     * de super.toString() para complementar conversão de PersonagemAbstrato.
     */
    @Override
    public String toString() {

        String resultado = super.toString();
        resultado = resultado + "Experiência concedida: " + this.xpConcedido;
        resultado = "\n--------------------------\n" + resultado + "\n\n--------------------------\n";

        return resultado;
    }

    /**
    *  Método adapatado para exibir status de herói.
    * */
    @Override
    public void exibirStatus() {
        System.out.println(this);
    }

    /**
    *  Método para exibir apresentação do monstro.
    * */
    public void apresentacao () {
        System.out.println(this.fraseApresentacao);
    }

    /**
     * Método responsável por dropar loot do monstro, quando este morre.
     * Seleciona-se, aleatoriamente, um dos três itens que podem ser largados
     * da lista de Armas.
     */
    public InterfaceItem droparLoot() {
        Random random = new Random();
        int numAleat = random.nextInt(0,this.listaDeArmasParaLargar.length);

        return this.listaDeArmasParaLargar[numAleat];
    }

}
