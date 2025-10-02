package com.rpg.combate;
import com.rpg.exception.HabilidadeAntesdeVidaSuficiente;
import com.rpg.personagens.HeroiAbstrato;
import com.rpg.personagens.InterfaceCombatente;
import com.rpg.personagens.MonstroAbstrato;
import java.util.Random;

public class AtaqueAuraDaJustiça implements InterfaceAcaoDeCombate {

    /**
     * Método da habilidade especial do Paladino. Quando o número sorteado + 5*(nível+1) + acaso 
     * >= 70%, ele é capaz de infligir quantidades massivas de dano.
     */
    public void executar (InterfaceCombatente usuario, InterfaceCombatente alvo) throws HabilidadeAntesdeVidaSuficiente{

        HeroiAbstrato usuarioHeroi = (HeroiAbstrato) usuario;
        MonstroAbstrato alvoMonstro = (MonstroAbstrato) alvo;

        Random random = new Random();
        int numAleat = random.nextInt(0, 100);
        int extra = 5 * usuarioHeroi.getFatorEspecial();
        int dano = usuarioHeroi.getDanoArma();

        if(usuarioHeroi.getPontosDeVida() > 4 * (usuarioHeroi.getNivel() + 2)){
            System.out.println("cheguei aki");
            throw new HabilidadeAntesdeVidaSuficiente();
        }


        int acaso = 10 * usuarioHeroi.getSorte() / 25;
        if (usuarioHeroi.getSorte() <= 40) {
            acaso = -acaso;
        }

        if (numAleat + 5 * (usuarioHeroi.getNivel() + 1) + acaso > 70) {
            dano += usuarioHeroi.getForca() + extra;
            alvo.receberDano(dano);

            System.out.println(usuarioHeroi.getNome() + ": *** ACERTOU A HABILIDADE ESPECIAL [ AURA DA JUSTIÇA ]: " + dano + " Dano ***");
            System.out.println(usuarioHeroi.getFraseDeEfeito());

            if (alvoMonstro.getPontosDeVida() <= 0) {
                usuarioHeroi.ganhaExperiencia(alvoMonstro.getXpConcedido());
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
            System.out.println("\r" + usuarioHeroi.getNome() + ": *** ERROU A HABILIDADE ESPECIAL ***");
        }

    }

}

