import java.util.Random;

public class AtaqueHeroiSimples implements iacaoDeCombate {

    public void executar(iCombatente usuario, iCombatente alvo) {

        if (usuario instanceof HeroiAbstrato && alvo instanceof MonstroAbstrato) {

            HeroiAbstrato usuarioHeroi = (HeroiAbstrato) usuario;
            MonstroAbstrato usuarioAlvo = (MonstroAbstrato) alvo;
            int dano;
            Random random = new Random();
            int numAleat = random.nextInt(0, 100);

            int extra = 10 * usuarioHeroi.nivel;
            if (usuarioHeroi.arma == null) {
                dano = 0;
            } else {
                dano = usuarioHeroi.arma.dano;
            }

            if (numAleat + extra > 30) {
                dano += usuarioHeroi.forca;
                usuarioAlvo.receberDano(dano);

                System.out.println(usuarioHeroi.nome + ": *** ACERTOU O ATAQUE : " + dano + " Dano ***");
                System.out.println(usuarioHeroi.fraseDeEfeito);

                if (usuarioAlvo.PontosDeVida <= 0) {
                    usuarioHeroi.ganhaExperiencia(usuarioAlvo.xpConcedido);
                    Arma armaLargada = usuarioAlvo.largaArma();
                    if (armaLargada.minNivel <= usuarioHeroi.nivel) {
                        usuarioHeroi.equiparArma(armaLargada);
                    }
                }
                
            } else {
                    System.out.println("\r" + usuarioHeroi.nome + ": *** ERROU ATAQUE***");
                }

        } 

    }

}
