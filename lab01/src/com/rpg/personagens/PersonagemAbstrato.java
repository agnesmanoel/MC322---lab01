package com.rpg.personagens;
import com.rpg.combate.InterfaceAcaoDeCombate;
import com.rpg.itens.Arma;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class PersonagemAbstrato implements InterfaceCombatente{
    
    public  String nome;
    public  int PontosDeVida;
    public  int forca;
    protected String imagemURL;
    public Arma arma;
    protected List<InterfaceAcaoDeCombate> listaCombates = new ArrayList<>();


    /**
     * Método construtor abstrato
     * @param n : nome;
     * @param pv : vida;
     * @param f : força;
     * @param URL : imagem ASCII do personagem.
     */
    public PersonagemAbstrato(String n, int pv, int f, String URL, Arma arma) {
        this.nome = n;
        this.PontosDeVida = pv;
        this.forca = f;
        this.imagemURL = URL;
        this.arma = arma;
    }

    /**
     *  Método para receber dano e, então, diminuir a vida do personagem. O método recebe:
     *      dano.
    * */
    public void receberDano(int dano) {
        this.PontosDeVida = Math.max(this.PontosDeVida - dano, 0);
    }

    public void receberCura(int cura) {
        this.PontosDeVida = this.PontosDeVida += cura;
    }

    /** 
     * Método de conversão do objeto em uma String através de override em toString.
     * */
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
     * */
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
    * */
    public void exibirStatus() {
       System.out.println(this);
    }

    /**
     *  Método getter para retornar o nome do personagem.
    * */
    public  String getNome(){
        return this.nome;
    }

    /**
     * Método para checar se o personagem está vivo.
     */
    public boolean estaVivo(){
        return this.PontosDeVida > 0;
    }

}
