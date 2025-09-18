import java.util.Random;

public class AtaqueAuraDaJustiça implements iacaoDeCombate {

    public void executar(iCombatente usuario, iCombatente alvo) {

            HeroiAbstrato heroi = (HeroiAbstrato) usuario;
            MonstroAbstrato monstro = (MonstroAbstrato) alvo;

            int dano;
            Random random = new Random();
            int numAleat = random.nextInt(0, 100);
            int extra = 5 * heroi.fatorEspecial;
            if (heroi.arma == null) {
                dano = 0;
            } else {
                dano = heroi.arma.dano;
            }

            int acaso = 10 * heroi.sorte / 25;
            if (heroi.sorte <= 40) {
                acaso = -acaso;
            }

            if (numAleat + 5 * (heroi.nivel + 1) + acaso > 70) {
                dano += heroi.forca + extra;
                alvo.receberDano(dano);

                System.out.println(
                        heroi.nome + ": *** ACERTOU A HABILIDADE ESPECIAL AURA DA JUSTIÇA: " + dano + " Dano ***");
                System.out.println(heroi.fraseVitoria);

                if (monstro.PontosDeVida <= 0) {
                    heroi.ganhaExperiencia(monstro.xpConcedido);
                    Arma armaLargada = monstro.largaArma();
                    if (armaLargada.minNivel <= heroi.nivel) {
                        heroi.equiparArma(armaLargada);
                    }
                }

            }

            else {
                System.out.println("\r" + heroi.nome + ": *** ERROU A HABILIDADE ESPECIAL ***");
            }

        }

    }

