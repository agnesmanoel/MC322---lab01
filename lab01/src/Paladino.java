import java.util.Random;

public class Paladino extends HeroiAbstrato{
    
    private int AuraDaJustica; 

    /** 
     * Método construtor de Paladino. O objeto é inicializado com 12 de vida e 9 de força.
     */
    public Paladino() {
        super("Paladino", 12, 9, "- Paladino: Os meus deuses ajudam os justos!", "- Paladino: Que sua alma perturbada descanse enfim...","lab01/imagens-texto/paladino.txt");
        this.AuraDaJustica = 1;
    }

    /* 
     * Método concreto de ataque simples. A chance de acerto é 70% + (10 * nível atual)%
     * Já o dano é dado pela força do objeto.
     */
    public void atacar(PersonagemAbstrato alvo) {

        MonstroAbstrato monstro;

        if (alvo instanceof MonstroAbstrato) {
            monstro = (MonstroAbstrato) alvo;
        }
        else {
            return;
        }
        
        int dano;
        Random random = new Random();
        int numAleat = random.nextInt(0,100);
        
        int extra;
        if (this.arma == null) {extra = 10 * this.nivel;}
        else {extra = 10 * this.nivel + this.arma.dano;}

        if (numAleat + extra > 30) {
            dano = this.forca;
            monstro.receberDano(dano);

            System.out.println(this.nome + ": *** ACERTOU O ATAQUE ***");
            System.out.println(this.fraseDeEfeito);

            if (monstro.PontosDeVida <= 0) {
                ganhaExperiencia(monstro.xpConcedido);
                if(monstro.arma.minNivel <= this.nivel){
                    this.equiparArma(monstro.arma);
                }
            }
            
        }

        else {System.out.println("\r" + this.nome + ": *** ERROU O ATAQUE ***"); }
    }

    /* 
     * Método concreto de habilidade especial. A chance de acerto é 30% + (5 * (nível atual + 1))% .
     * Já o dano final é composto por força + (5 * AuraDaJustiça).
     */
    public void usarHabilidadeEspecial(PersonagemAbstrato alvo) {
        
        MonstroAbstrato monstro;

        if (alvo instanceof MonstroAbstrato) {
            monstro = (MonstroAbstrato) alvo;
        }
        else {
            return;
        }

        int dano;
        Random random = new Random();
        int numAleat = random.nextInt(0,100);
        int extra = 5 * this.AuraDaJustica;
        
        int acaso;
        if (this.sorte > 40) {acaso = 10*sorte/25;}
        else {acaso =  - 10*sorte/25;}

        if (numAleat + 5 * (this.nivel + 1) + acaso > 70) {
            dano = this.forca + extra;
            monstro.receberDano(dano);
            
            System.out.println(this.nome + ": *** ACERTOU A HABILIDADE ESPECIAL ***");
            System.out.println(this.fraseVitoria);
            
            if (! monstro.estaVivo()) { this.ganhaExperiencia(monstro.xpConcedido); }
   
        }

        else { System.out.println("\r" + this.nome + ": *** ERROU A HABILIDADE ESPECIAL ***"); }

    }

    /**
     * Método aprimorado para incrementar habilidade especial a cada nível completado.
     */
    @Override
    protected void ganhaNivel() {
        super.ganhaNivel();
        this.AuraDaJustica ++;
    }

}
