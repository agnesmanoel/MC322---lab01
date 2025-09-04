import java.util.Random;

public class Feiticeira extends HeroiAbstrato {

    private int PocaoAstral;

    /** 
     * Método construtor de Feiticeira. O objeto é inicializado com 16 de vida e 8 de força.
     */
    public Feiticeira () {
        super("Feiticeira", 16, 8, "- Feiticeira: Você erra ao me subestimar, aberração...", "- Feiticeira: A Natureza não terá piedade dos seus restos!","lab01/imagens-texto/feiticeira.txt");
        this.PocaoAstral = 1;
    }

    /* 
     * Método concreto de ataque simples. A chance de acerto é 65% + (10 * nível atual)%
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
        int extra = 10 * this.nivel;

        if (numAleat + extra > 45) {
            dano = this.forca;
            monstro.receberDano(dano);

            System.out.println(this.nome + ": *** ACERTOU O ATAQUE ***");
            System.out.println(this.fraseDeEfeito);

            if (monstro.PontosDeVida <= 0) { ganhaExperiencia(monstro.xpConcedido); }

            
        }
        
        else {System.out.println("\r" + this.nome + ": *** ERROU O ATAQUE ***"); }
    }

    /* 
     * Método concreto de habilidade especial. A chance de acerto é 60%, e só pode ser 
     * utilizada quando sua vida é menor ou igual a 4 * (nível + 2). Já o dano final 
     * é composto por PocaoDeVida * (nível + 3). A Feiticeira recupera de vida a mesma
     * magnitude de dano infligido.
     */
    public void usarHabilidadeEspecial(PersonagemAbstrato alvo) {

        MonstroAbstrato monstro;

        if (alvo instanceof MonstroAbstrato) {
            monstro = (MonstroAbstrato) alvo;
        }
        else {
            return;
        }

        Random random = new Random();
        int numAleat = random.nextInt(0,100);
        int dano = (this.nivel + 3) * this.PocaoAstral;

        if (numAleat > 60 && this.PontosDeVida <= 4 * (this.nivel + 2)) {
            monstro.receberDano(dano);
            this.PontosDeVida += dano;

            System.out.println(this.nome + ": *** ACERTOU A HABILIDADE ESPECIAL ***");
            System.out.println(this.fraseDeEfeito);

            if (monstro.PontosDeVida <= 0) { ganhaExperiencia(monstro.xpConcedido); }
            
        }

        else { System.out.println("\r" + this.nome + ": *** ERROU A HABILIDADE ESPECIAL ***"); }

    }

    /**
     * Método aprimorado para incrementar habilidade especial a cada nível completado.
     */
    @Override
    protected void ganhaNivel() {
        super.ganhaNivel();
        this.PocaoAstral ++;
    }
}
