package com.rpg.personagens;
import com.rpg.combate.AtaqueAuraDaJustiça;
import com.rpg.combate.AtaqueHeroiSimples;
import com.rpg.combate.InterfaceAcaoDeCombate;
import java.util.Random;

public class Paladino extends HeroiAbstrato{
    

    /** 
     * Método construtor de Paladino. O objeto é inicializado com 12 de vida e 9 de força.
     */
    public Paladino() {
        super("Paladino", 12, 9, "- Paladino: Os meus deuses ajudam os justos!", "- Paladino: Que sua alma perturbada descanse enfim...","lab01/imagens-texto/paladino.txt");
        this.listaCombates.add(new AtaqueHeroiSimples());
        this.listaCombates.add(new AtaqueAuraDaJustiça());
    }

    /**
     * Método responsável por escolher, aleatoriamente, a ação de combate do Paladino. 
     * Ele tem 65% de aplicar golpe normal sobre o alvo; e 35% de utilizar a Habilidade Especial.
     */
    public InterfaceAcaoDeCombate escolherAcao(InterfaceCombatente alvo) {
        Random random = new Random();
        int flagAtac = random.nextInt(0, 100);
        if (flagAtac <= 65) { return this.listaCombates.get(0); }
        else { return this.listaCombates.get(1); }
    }

    

}
