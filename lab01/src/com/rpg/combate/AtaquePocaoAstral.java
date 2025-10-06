package com.rpg.combate;
import com.rpg.exception.HabilidadeAntesdeVidaSuficiente;
import com.rpg.personagens.HeroiAbstrato;
import com.rpg.personagens.InterfaceCombatente;
import com.rpg.personagens.MonstroAbstrato;
import java.util.Random;

/**
 * Classe que implementa InterfaceAcaoDeCombate, representando a ação de combate
 * de uma Feiticeira, quando utiliza sua habilidade especial. Como particularidade,
 * o ataque gera dano no oponente à medida que cura o usuário.
 * 
 * @author : Agnes Manoel e Bernardo Nascimento
 */
public class AtaquePocaoAstral implements InterfaceAcaoDeCombate{

    /**
     * Método que implementa a habilidade especial da Feiticeira. Em sua ação,
     * quando o número sorteado + o acaso >= 50, ela é capaz de roubar vida do inimigo,
     * infligindo dano ao mesmo tempo em que recupera sua prória vida.
     */
    public void executar(InterfaceCombatente usuario, InterfaceCombatente alvo) throws HabilidadeAntesdeVidaSuficiente{
        HeroiAbstrato usuarioHeroi = (HeroiAbstrato) usuario;
        MonstroAbstrato alvoMonstro = (MonstroAbstrato) alvo;

        if(usuarioHeroi.getPontosDeVida() > 4 * (usuarioHeroi.getNivel() + 2)){
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
            } 
        }
        else {
            System.out.println("\r" + usuarioHeroi.getNome() + ": *** ERROU A HABILIDADE ESPECIAL ***");
        }
    }
    
}

