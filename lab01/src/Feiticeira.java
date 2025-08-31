import java.util.Random;

public class Feiticeira extends HeroiAbstrato {

    private int PocaoAstral;

    public Feiticeira () {
        super("Feiticeira", 16, 8, "Feiticeira: Você erra ao me subestimar, aberração...", "Feiticeira: A Natureza não terá piedade dos seus restos!","lab01/imagens-texto/feiticeira.txt");
        this.PocaoAstral = 1;
    }

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

        if (numAleat + extra > 50) {
            dano = this.forca;
            monstro.receberDano(dano);

            System.out.println(this.fraseDeEfeito);

            if (monstro.PontosDeVida <= 0) { ganhaExperiencia(monstro.xpConcedido); }

            
        }
        
        else {System.out.println("\r" + this.nome + ": *** ERROU O ATAQUE ***"); }
    }

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
        int dano = (this.nivel + 1) * this.PocaoAstral;

        if (numAleat > 50 && this.PontosDeVida <= 4 * (this.nivel + 1)) {
            monstro.receberDano(dano);
            this.PontosDeVida += dano;

            System.out.println(this.fraseDeEfeito);

            if (monstro.PontosDeVida <= 0) { ganhaExperiencia(monstro.xpConcedido); }
            
        }

        else { System.out.println("\r" + this.nome + ": *** ERROU A HABILIDADE ESPECIAL ***"); }

    }

    
}
