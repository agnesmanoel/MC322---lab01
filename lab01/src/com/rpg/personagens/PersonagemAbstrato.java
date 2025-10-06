package com.rpg.personagens;
import com.rpg.combate.InterfaceAcaoDeCombate;
import com.rpg.itens.Arma;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Classe abstrata para todas as entidades vivas no jogo - até o momento,
 *  heróis e monstros - implementa InterfaceCombatente. Aqui, são definidos 
 * atributos e métodos essenciais. A título de exemplo, nome, vida, força, 
 * imagem, arma e descrição, bem como seus respectivos getters, e modificadores.
 * 
 * @author : Agnes Manoel e Bernardo Nascimento
 */
abstract class PersonagemAbstrato implements InterfaceCombatente{
    
    protected  String nome;
    protected String descr;
    protected  int PontosDeVida;
    protected  int forca;
    protected String imagemURL;
    protected Arma arma;
    protected List<InterfaceAcaoDeCombate> listaCombates = new ArrayList<>();


    /**
     * Método construtor abstrato
     * 
     * @param n : nome;
     * @param pv : vida;
     * @param f : força;
     * @param URL : imagem ASCII do personagem;
     * @param arma : arma do personagem;
     * @param descr : descrição do personagem.
     */
    public PersonagemAbstrato(String n, int pv, int f, String URL, Arma arma, String descr) {
        this.nome = n;
        this.PontosDeVida = pv;
        this.forca = f;
        this.imagemURL = URL;
        this.arma = arma;
        this.descr = descr;
    }

    /**
    *  Método getter para retornar o nome do personagem.
    * 
    * @return : nome do personagem (String).
    */
    public  String getNome(){
        return this.nome;
    }

    /**
    * Método getter para retornar a descrição do personagem.
    * 
    * @return : descrição do personagem (String).
    */
    public  String getDescricao(){
        return this.descr;
    }

    /**
    * Método getter para retornar a vida do personagem.
    * 
    * @return : vida do personagem (int).
    */
    public int getPontosDeVida() {
        return this.PontosDeVida;
    }

    /**
    * Método getter para retornar a força do personagem.
    * 
    * @return : força do personagem (int).
    */
    public int getForca() {
        return this.forca;
    }

    /**
    * Método getter para retornar o nome da arma do personagem.
    * 
    * @return : nome da arma do personagem (String);
    */
    public String getArma() {
        if (this.arma != null){
            return this.arma.getNome();
        }
        else{ return "";}
    }

    /**
    * Método getter para retornar o dano da arma do personagem.
    *    
    * @return : dano da arma do personagem (int).
    */
    public int getDanoArma() {
        if (this.arma != null){
            return this.arma.getDano();
        }
        else{ return 0;}
    }

    /**
    *  Método para receber dano e, então, diminuir a vida do personagem.
    * 
    * @param dano : dano a ser recebido (int).
    */
    public void receberDano(int dano) {
        this.PontosDeVida = Math.max(this.PontosDeVida - dano, 0);
    }

    /**
    *  Método para receber cura e, então, aumentar a vida do personagem.
    * 
    * @param cura : cura a ser recebida (int).
    */
    public void receberCura(int cura) {
        this.PontosDeVida = this.PontosDeVida += cura;
    }

    /** 
    * Método de conversão do objeto em uma String através de override em toString.
    * São exibidos nome, vida, força e dano da arma (caso exista).
    */
    @Override
    public String toString() {

       String resultado = "Nome: "+this.nome+"\n";

       if (this.estaVivo()) {resultado = resultado+"Vida: "+this.PontosDeVida+"\n";}
       else {resultado = resultado+"Vida: * MORTO *\n";}
       
       if (this.arma == null || !this.estaVivo()) { resultado = resultado+"Força: "+this.forca+"\n"; }
       else { resultado = resultado+"Força: "+this.forca+" (+" + this.arma.dano + ")"+"\n"; }
       
        return resultado;
    }

    /**
    * Método para retornar imagem associada a um personagem.
    * 
    * @return : imagem do personagem (String).
    */
    public String getFileImage(){
        String image = "\n";
        File imagem = new File(this.imagemURL);
        try {
            Scanner reader = new Scanner(imagem);
            while(reader.hasNextLine()){
                String linha = reader.nextLine();
                image = image + linha + "\n";
            } reader.close();
         }  
            catch (FileNotFoundException e) {
                System.out.println("erro ao achar URL AAAAAAAAAAAAAAA");
                return "erro nao foi possivel ler";

        }

        return image;

    }

    /**
    *  Método inicial para exibir status de personagem.
    * 
    * @return : status do personagem (String).
    */
    public void exibirStatus() {
       System.out.println(this);
    }

    /**
    * Método para checar se o personagem está vivo.
    * 
    * @return : true, se a vida for maior que 0; false, caso contrário.
    */
    public boolean estaVivo(){
        return this.PontosDeVida > 0;
    }

}
