package com.rpg.combate;
import java.util.Random;

import com.rpg.exception.HabilidadeAntesdeVidaSuficiente;
import com.rpg.personagens.HeroiAbstrato;
import com.rpg.personagens.MonstroAbstrato;
import com.rpg.personagens.iCombatente;

public class AtaquePocaoAstral implements iacaoDeCombate{

    /**
     * Método que implementa a habilidade especial da Feiticeira. Em sua ação,
     * quando o número sorteado + o acaso >= 50, ela é capaz de roubar vida do inimigo,
     * infligindo dano ao mesmo tempo em que recupera sua prória vida.
     */
    public void executar(iCombatente usuario, iCombatente alvo) throws HabilidadeAntesdeVidaSuficiente{
        HeroiAbstrato usuarioHeroi = (HeroiAbstrato) usuario;
        MonstroAbstrato alvoMonstro = (MonstroAbstrato) alvo;

        if(usuarioHeroi.PontosDeVida > 4 * (usuarioHeroi.nivel + 2)){
            System.out.println("cheguei aki");
            throw new HabilidadeAntesdeVidaSuficiente();
        }

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
               // Arma armaLargada = (Arma) alvoMonstro.droparLoot();
                    //try {usuarioHeroi.equiparArma(armaLargada);} catch(mininsuficienteArma e) {
                      //  System.out.println("++VOCÊ NÃO TEM NÍVEL SUFICIENTE PARA EQUIPAR ESSA ARMA**");
                    //}

            } 
        }
        else {
            System.out.println("\r" + usuarioHeroi.nome + ": *** ERROU A HABILIDADE ESPECIAL ***");
        }
    }
    
}

