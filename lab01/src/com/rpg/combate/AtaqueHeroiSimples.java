package com.rpg.combate;
import com.rpg.personagens.HeroiAbstrato;
import com.rpg.personagens.InterfaceCombatente;
import com.rpg.personagens.MonstroAbstrato;
import java.util.Random;

public class AtaqueHeroiSimples implements InterfaceAcaoDeCombate {

    // Método de ataque simples dos heróis.
    public void executar(InterfaceCombatente usuario, InterfaceCombatente alvo) {

        if (usuario instanceof HeroiAbstrato && alvo instanceof MonstroAbstrato) {

            HeroiAbstrato usuarioHeroi = (HeroiAbstrato) usuario;
            MonstroAbstrato alvoMonstro = (MonstroAbstrato) alvo;
            Random random = new Random();
            int numAleat = random.nextInt(0, 100);

            int extra = 10 * usuarioHeroi.getNivel();
            int dano = usuarioHeroi.getDanoArma();

            if (numAleat + extra > 30) {
                dano += usuarioHeroi.getForca();
                alvoMonstro.receberDano(dano);

                System.out.println(usuarioHeroi.getNome() + ": *** ACERTOU O ATAQUE : " + dano + " Dano ***");
                System.out.println(usuarioHeroi.getFraseDeEfeito());

                if (alvoMonstro.getPontosDeVida() <= 0) {
                    usuarioHeroi.ganhaExperiencia(alvoMonstro.getXpConcedido());
                   // Arma armaLargada = (Arma) alvoMonstro.droparLoot();
                     //   try{
                       //     usuarioHeroi.equiparArma(armaLargada);
                        //} 
                        //catch(mininsuficienteArma e){
                          //  System.out.println("*VOCÊ NÃO TEM NÍVEL SUFICIENTE PARA EQUIPAR ESSA ARMA");
                        //}
                    
                }  
            } 
            else {
                System.out.println("\r" + usuarioHeroi.getNome() + ": *** ERROU O ATAQUE ***");
            }
        } 
    }

}
