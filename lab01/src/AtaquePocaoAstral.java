import java.util.Random;

public class AtaquePocaoAstral implements iacaoDeCombate{

    /**
     * Método que implementa a habilidade especial da Feiticeira. Em sua ação,
     * quando o número sorteado + o acaso >= 50, ela é capaz de roubar vida do inimigo,
     * infligindo dano ao mesmo tempo em que recupera sua prória vida.
     */
    public void executar(iCombatente usuario, iCombatente alvo) {
        HeroiAbstrato usuarioHeroi = (HeroiAbstrato) usuario;
        MonstroAbstrato alvoMonstro = (MonstroAbstrato) alvo;

        Random random = new Random();
        int numAleat = random.nextInt(0,100);
        int dano = (usuarioHeroi.nivel + 3) * usuarioHeroi.fatorEspecial ; 

        int acaso = 10*usuarioHeroi.sorte/25; // Influência da sorte do personagem
        if (usuarioHeroi.sorte <= 40) {acaso = - acaso;}

        if (numAleat + acaso > 50 && usuarioHeroi.PontosDeVida <= 4 * (usuarioHeroi.nivel + 2)) {
            alvoMonstro.receberDano(dano);
            usuarioHeroi.PontosDeVida += dano;

            System.out.println(usuarioHeroi.nome + ": *** ACERTOU A HABILIDADE ESPECIAL [ POÇÃO ASTRAL ] :  " + dano + " Dano  +" + dano + " Vida ***");
            System.out.println(usuarioHeroi.fraseDeEfeito);

            if (alvoMonstro.PontosDeVida <= 0) {
                usuarioHeroi.ganhaExperiencia(alvoMonstro.xpConcedido);
                // Arma armaLargada = alvoMonstro.largaArma();
                Arma armaLargada = (Arma) alvoMonstro.droparLoot();
                if(armaLargada.minNivel <= usuarioHeroi.nivel){
                    usuarioHeroi.equiparArma(armaLargada);
                }
            } 
        }
        else {
            System.out.println("\r" + usuarioHeroi.nome + ": *** ERROU A HABILIDADE ESPECIAL ***");
        }
    }
    
}

