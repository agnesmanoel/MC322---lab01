import java.util.Random;

public class Paladino extends HeroiAbstrato{
    
    private int AuraDaJustica; 

    public Paladino() {
        super("Paladino", 12, 10, "Os meus deuses ajudam os justos!", "Que sua alma perturbada descanse enfim...");
        this.AuraDaJustica = 1;
    }

    public void atacar(MonstroAbstrato alvo) {
        
        int dano;
        Random random = new Random();
        int numAleat = random.nextInt(0,100);
        int extra = 10 * this.nivel;

        if (numAleat + extra > 50) {
            dano = this.forca;
            alvo.receberDano(dano);

            if (alvo.PontosDeVida <= 0) {
                ganhaExperiencia(alvo.xpConcedido);
            }

            System.out.println(this.fraseDeEfeito);
        }
    }

    public void usarHabilidadeEspecial(MonstroAbstrato alvo) {
        
        int dano;
        Random random = new Random();
        int numAleat = random.nextInt(0,100);
        int extra = 5 * this.AuraDaJustica;

        if (numAleat > 85) {
            dano = this.forca + extra;
            alvo.receberDano(dano);

            if (alvo.PontosDeVida <= 0) {
                ganhaExperiencia(alvo.xpConcedido);
            }

            System.out.println(this.fraseDeEfeito);
        }

    }

}
