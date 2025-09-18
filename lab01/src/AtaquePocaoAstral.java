import java.util.Random;

public class AtaquePocaoAstral implements iacaoDeCombate{

    public void executar(iCombatente usuario, iCombatente alvo) {
        HeroiAbstrato heroi = (HeroiAbstrato) usuario;
        MonstroAbstrato alvoMonstro = (MonstroAbstrato) alvo;

        Random random = new Random();
            int numAleat = random.nextInt(0,100);
            int dano = (heroi.nivel + 3) * heroi.fatorEspecial ; 
    
            int acaso = 10*heroi.sorte/25;
            if (heroi.sorte <= 40) {acaso = - acaso;}
    
            if (numAleat + acaso > 50 && heroi.PontosDeVida <= 4 * (heroi.nivel + 2)) {
                alvoMonstro.receberDano(dano);
                heroi.PontosDeVida += dano;
    
                System.out.println(heroi.nome + ": *** ACERTOU A HABILIDADE ESPECIAL POCAO ASTRAL :  " + dano + " Dano  +" + dano + " Vida ***");
                System.out.println(heroi.fraseDeEfeito);
    
                if (alvoMonstro.PontosDeVida <= 0) {
                    heroi.ganhaExperiencia(alvoMonstro.xpConcedido);
                    Arma armaLargada = alvoMonstro.largaArma();
                    if(armaLargada.minNivel <= heroi.nivel){
                        heroi.equiparArma(armaLargada);
                    }
                } else {
                    System.out.println("\r" + heroi.nome + ": *** ERROU A HABILIDADE ESPECIAL ***");
                }
            }
    }
    
}

