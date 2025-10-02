package com.rpg.combate;
import com.rpg.exception.HabilidadeAntesdeVidaSuficiente;
import com.rpg.personagens.HeroiAbstrato;
import com.rpg.personagens.InterfaceCombatente;
import com.rpg.personagens.MonstroAbstrato;
import java.util.Random;

public class AtaquePocaoAstral implements InterfaceAcaoDeCombate{

    /**
     * Método que implementa a habilidade especial da Feiticeira. Em sua ação,
     * quando o número sorteado + o acaso >= 50, ela é capaz de roubar vida do inimigo,
     * infligindo dano ao mesmo tempo em que recupera sua prória vida.
     */
    public void executar(InterfaceCombatente usuario, InterfaceCombatente alvo) throws HabilidadeAntesdeVidaSuficiente{
        HeroiAbstrato usuarioHeroi = (HeroiAbstrato) usuario;
        MonstroAbstrato alvoMonstro = (MonstroAbstrato) alvo;

        if(usuarioHeroi.PontosDeVida > 4 * (usuarioHeroi.getNivel() + 2)){
            System.out.println("cheguei aki");
            throw new HabilidadeAntesdeVidaSuficiente();
        }

        Random random = new Random();
        int numAleat = random.nextInt(0,100);
        int dano = (usuarioHeroi.getNivel() + 3) * usuarioHeroi.getFatorEspecial() ; 

        int acaso = 10*usuarioHeroi.getSorte()/25; // Influência da sorte do personagem
        if (usuarioHeroi.getSorte() <= 40) {acaso = - acaso;}

        if (numAleat + acaso > 50 && usuarioHeroi.getPontosDeVida() <= 4 * (usuarioHeroi.getNivel() + 2)) {
            alvoMonstro.receberDano(dano);
            usuarioHeroi.receberCura(dano);

            System.out.println(usuarioHeroi.getNome() + ": *** ACERTOU A HABILIDADE ESPECIAL [ POÇÃO ASTRAL ] :  " + dano + " Dano  +" + dano + " Vida ***");
            System.out.println(usuarioHeroi.getFraseDeEfeito());

            if (alvoMonstro.getPontosDeVida() <= 0 ) {
                usuarioHeroi.ganhaExperiencia(alvoMonstro.getXpConcedido());
                // Arma armaLargada = alvoMonstro.largaArma();
               // Arma armaLargada = (Arma) alvoMonstro.droparLoot();
                    //try {usuarioHeroi.equiparArma(armaLargada);} catch(mininsuficienteArma e) {
                      //  System.out.println("++VOCÊ NÃO TEM NÍVEL SUFICIENTE PARA EQUIPAR ESSA ARMA**");
                    //}

            } 
        }
        else {
            System.out.println("\r" + usuarioHeroi.getNome() + ": *** ERROU A HABILIDADE ESPECIAL ***");
        }
    }
    
}

