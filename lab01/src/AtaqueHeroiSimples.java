import java.util.Random;

public class AtaqueHeroiSimples implements iacaoDeCombate {

    // Método de ataque simples dos heróis.
    public void executar(iCombatente usuario, iCombatente alvo) {

        if (usuario instanceof HeroiAbstrato && alvo instanceof MonstroAbstrato) {

            HeroiAbstrato usuarioHeroi = (HeroiAbstrato) usuario;
            MonstroAbstrato alvoMonstro = (MonstroAbstrato) alvo;
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
                alvoMonstro.receberDano(dano);

                System.out.println(usuarioHeroi.nome + ": *** ACERTOU O ATAQUE : " + dano + " Dano ***");
                System.out.println(usuarioHeroi.fraseDeEfeito);

                if (alvoMonstro.PontosDeVida <= 0) {
                    usuarioHeroi.ganhaExperiencia(alvoMonstro.xpConcedido);
                    Arma armaLargada = (Arma) alvoMonstro.droparLoot();
                        try{
                            usuarioHeroi.equiparArma(armaLargada);
                        } 
                        catch(mininsuficienteArma e){
                            System.out.println("*VOCÊ NÃO TEM NÍVEL SUFICIENTE PARA EQUIPAR ESSA ARMA");
                        }
                    
                }  
            } 
            else {
                System.out.println("\r" + usuarioHeroi.nome + ": *** ERROU O ATAQUE ***");
            }
        } 
    }

}
