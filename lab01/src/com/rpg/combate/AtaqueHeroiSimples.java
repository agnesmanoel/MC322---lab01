package com.rpg.combate;
import com.rpg.personagens.HeroiAbstrato;
import com.rpg.personagens.InterfaceCombatente;
import com.rpg.personagens.MonstroAbstrato;
import java.util.Random;

/**
 * Classe que implementa InterfaceAcaoDeCombate, representando a ação de combate
 * de um herói qualquer, quando utiliza seu ataque simples.
 * 
 * @author : Agnes Manoel e Bernardo Nascimento
 */
public class AtaqueHeroiSimples implements InterfaceAcaoDeCombate {

    /**
     * Método que implementa o ataque simples de um herói. O usuário possui 70%
     * de chance de acerto (mais um extra de 10% por nível), e o dano é igual à 
     * força do usuário + dano da arma.
     */
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
                    
                }  
            } 
            else {
                System.out.println("\r" + usuarioHeroi.getNome() + ": *** ERROU O ATAQUE ***");
            }
        } 
    }

}
