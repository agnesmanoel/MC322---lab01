import java.util.Random;

public class Paladino extends HeroiAbstrato{
    
    private int AuraDaJustica; 

    public Paladino() {
        super("Paladino", 12, 5, "Paladino: Os meus deuses ajudam os justos!", "Paladino: Que sua alma perturbada descanse enfim...");
        this.AuraDaJustica = 1;
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

            if (monstro.PontosDeVida <= 0) {
                ganhaExperiencia(monstro.xpConcedido);
            }

            System.out.println(this.fraseDeEfeito);
        }
    }

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

        if (numAleat + 5 * (this.nivel + 1) > 85) {
            dano = this.forca + extra;
            monstro.receberDano(dano);

            if (monstro.PontosDeVida <= 0) {
                ganhaExperiencia(monstro.xpConcedido);
            }

            System.out.println(this.fraseDeEfeito);
        }

    }

}
