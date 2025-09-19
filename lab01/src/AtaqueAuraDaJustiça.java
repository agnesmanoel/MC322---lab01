import java.util.Random;

public class AtaqueAuraDaJustiça implements iacaoDeCombate {

    /**
     * Método da habilidade especial do Paladino. Quando o número sorteado + 5*(nível+1) + acaso 
     * >= 70%, ele é capaz de infligir quantidades massivas de dano.
     */
    public void executar(iCombatente usuario, iCombatente alvo) {

        HeroiAbstrato usuarioHeroi = (HeroiAbstrato) usuario;
        MonstroAbstrato alvoMonstro = (MonstroAbstrato) alvo;

        int dano;
        Random random = new Random();
        int numAleat = random.nextInt(0, 100);
        int extra = 5 * usuarioHeroi.fatorEspecial;
        if (usuarioHeroi.arma == null) {
            dano = 0;
        } else {
            dano = usuarioHeroi.arma.dano;
        }

        int acaso = 10 * usuarioHeroi.sorte / 25;
        if (usuarioHeroi.sorte <= 40) {
            acaso = -acaso;
        }

        if (numAleat + 5 * (usuarioHeroi.nivel + 1) + acaso > 70) {
            dano += usuarioHeroi.forca + extra;
            alvo.receberDano(dano);

            System.out.println(usuarioHeroi.nome + ": *** ACERTOU A HABILIDADE ESPECIAL [ AURA DA JUSTIÇA ]: " + dano + " Dano ***");
            System.out.println(usuarioHeroi.fraseVitoria);

            if (alvoMonstro.PontosDeVida <= 0) {
                usuarioHeroi.ganhaExperiencia(alvoMonstro.xpConcedido);
                Arma armaLargada = (Arma) alvoMonstro.droparLoot();
                if (armaLargada.minNivel <= usuarioHeroi.nivel) {
                    usuarioHeroi.equiparArma(armaLargada);
                }
            }

        }

        else {
            System.out.println("\r" + usuarioHeroi.nome + ": *** ERROU A HABILIDADE ESPECIAL ***");
        }

    }

}

