import java.util.Random;

public class Feiticeira extends HeroiAbstrato {

    private int PocaoAstral;

    public Feiticeira () {
        super("Feiticeira", 16, 8, "Você erra ao me subestimar, aberração...", "A Natureza não terá piedade dos seus restos!");
        this.PocaoAstral = 1;
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

        Random random = new Random();
        int numAleat = random.nextInt(0,100);
        int dano = (this.nivel + 1) * this.PocaoAstral;

        if (numAleat > 50 && this.PontosDeVida <= 4 * (this.nivel + 1)) {
            alvo.receberDano(dano);
            this.PontosDeVida += dano;

            if (alvo.PontosDeVida <= 0) {
                ganhaExperiencia(alvo.xpConcedido);
            }

            System.out.println(this.fraseDeEfeito);
        }

    }

    
}
