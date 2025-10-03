package com.rpg.personagens;
import com.rpg.combate.InterfaceAcaoDeCombate;
import com.rpg.exception.mininsuficienteArma;
import com.rpg.itens.Arma;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class HeroiAbstrato extends PersonagemAbstrato {
    
    protected int nivel;
    protected int experiencia;
    protected  String fraseDeEfeito;
    protected  String fraseVitoria;
    protected int expProximoNivel;
    protected int sorte;
    protected int fatorEspecial;

    /**
     * Método construtor, o qual aplica super() para inicializar componentes de PersonagemAbstrato.
     * @param n : nome;
     * @param pv : vida;
     * @param f : força;
     * @param fraseEfeito : texto para frase dita quando se ataca inimigo;
     * @param fraseVitoria : texto para frase dita quando se usa a habilidade especial;
     * @param imageURL : imagem ASCII do personagem;
     * @param descr : descrição do herói.
     */
    public HeroiAbstrato(String n, int pv, int f, String fraseEfeito, String fraseVitoria, String imageURL, String descr) {
        super(n, pv, f, imageURL, null, descr);
        this.nivel = 0;
        this.experiencia = 0;
        this.fraseDeEfeito = fraseEfeito;
        this.fraseVitoria = fraseVitoria;
        this.expProximoNivel = 2;
        Random random = new Random();
        this.sorte = random.nextInt(0,100);
        this.fatorEspecial = 1;
        List<InterfaceAcaoDeCombate> listaCombates = new ArrayList<>();

    }

    public String getFraseDeEfeito() {
        return this.fraseDeEfeito;
    }

    public int getNivel() {
        return this.nivel;
    }

    public int getSorte() {
        return this.sorte;
    }

    public int getFatorEspecial() {
        return this.fatorEspecial;
    }

    /**
     * Método para aumentar o nível do herói. A upgrade, ele recebe incremento de vida 
     * igual ao novo nível alcançado, e mais uma unidade de força.
     */
    protected  void ganhaNivel() {
        this.nivel ++;
        this.receberCura(this.nivel);
        this.forca ++;
        this.fatorEspecial++;
        Random random = new Random();
        this.sorte = random.nextInt(0,100);

        if (this.sorte > 40) {
            System.out.println("*** SUBIU DE NÍVEL : +" + this.nivel + " Vida " + " +1 Força  +"+ this.sorte +"% Benção dos Deuses ***");
        }
        else {
            System.out.println("*** SUBIU DE NÍVEL : +" + this.nivel + " Vida " + " +1 Força  +"+ this.sorte +"% Madição Antiga ***");
        }
        
        
    }

    /**
     * Método para adquirir experiência após vitória sobre inimigo. Caso se esteja no nível 0, 
     * são necessários 2 xp para upgrade; no nível 1, são 7 xp; e para o nível 2, são 20 xp.
     * @param xp : experiência concedida pelo inimigo.
     */
    public void ganhaExperiencia(int xp) {
        
        this.experiencia += xp;
        
        switch(this.nivel) {
            case 0: 
                if (this.experiencia >= 2) {
                    this.experiencia = 0;
                    this.expProximoNivel = 5;
                    ganhaNivel();
                }
                break;
            
            case 1:
                if (this.experiencia >= 5) {
                    this.experiencia = 0;
                    this.expProximoNivel = 10;
                    ganhaNivel();
                }
                break;

            case 2:
                if (this.experiencia >= 10) {
                    this.experiencia = 0;
                    this.expProximoNivel = 15;
                    ganhaNivel();
                }
                break;
            default:
                if (this.experiencia >= 15) {
                        this.experiencia = 0;
                        this.expProximoNivel = 15;
                        ganhaNivel();
                    }
                    break;
        }
    }

    /**
     * Método de conversão do objeto em string a partir de overide sobre toString() e chamada 
     * de super.toString() para complementar conversão de PersonagemAbstrato.
     */
    @Override
    public String toString() {

        String resultado = super.toString();
        resultado = resultado + "Nível: " + this.nivel + "\n";
        resultado = resultado + "Experiência: " + this.experiencia;
        resultado = "\n---------------\n" + resultado + "\n---------------\n";
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
     * Método abstrato de escolha da ação de combate.
     */
    public abstract InterfaceAcaoDeCombate escolherAcao(InterfaceCombatente alvo);

    /**
     * Método para equipar arma encontrada após vitória em combate.
     * @param novaArma : arma largada pelo monstro derrotado.
     */
    public void equiparArma(Arma novaArma) throws mininsuficienteArma {
        if (novaArma.minNivel <= this.nivel) {
            if (this.arma == null) {
                this.arma = novaArma;
                System.out.println("*** ENCONTROU " + novaArma.intro + " ***");
            }
     } else { throw new mininsuficienteArma();}

    }
}
