package com.rpg.combate;
import java.util.Random;

import com.rpg.exception.HabilidadeAntesdeVidaSuficiente;
import com.rpg.personagens.HeroiAbstrato;
import com.rpg.personagens.MonstroAbstrato;
import com.rpg.personagens.iCombatente;

public class AtaqueAuraDaJustiça implements iacaoDeCombate {

    /**
     * Método da habilidade especial do Paladino. Quando o número sorteado + 5*(nível+1) + acaso 
     * >= 70%, ele é capaz de infligir quantidades massivas de dano.
     */
    public void executar (iCombatente usuario, iCombatente alvo) throws HabilidadeAntesdeVidaSuficiente{

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

        if(usuarioHeroi.PontosDeVida > 4 * (usuarioHeroi.nivel + 2)){
            System.out.println("cheguei aki");
            throw new HabilidadeAntesdeVidaSuficiente();
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
               // Arma armaLargada = (Arma) alvoMonstro.droparLoot();
                //try{
                  //  usuarioHeroi.equiparArma(armaLargada);
                //} 
                //catch(mininsuficienteArma e){
                  //  System.out.println("*VOCÊ NÃO TEM NÍVEL SUFICIENTE PARA EQUIPAR ESSA ARMA");
                //}
            }

        }

        else {
            System.out.println("\r" + usuarioHeroi.nome + ": *** ERROU A HABILIDADE ESPECIAL ***");
        }

    }

}

