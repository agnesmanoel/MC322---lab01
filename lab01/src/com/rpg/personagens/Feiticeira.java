package com.rpg.personagens;
import java.util.Random;

import com.rpg.combate.AtaqueHeroiSimples;
import com.rpg.combate.AtaquePocaoAstral;
import com.rpg.combate.iacaoDeCombate;

public class Feiticeira extends HeroiAbstrato {

    /** 
     * Método construtor de Feiticeira. O objeto é inicializado com 16 de vida e 8 de força.
     */
    public Feiticeira () {
        super("Feiticeira", 16, 8, "- Feiticeira: Você erra ao me subestimar, aberração...", "- Feiticeira: A Natureza não terá piedade dos seus restos!","lab01/imagens-texto/feiticeira.txt");
        this.listaCombates.add(new AtaqueHeroiSimples());
        this.listaCombates.add(new AtaquePocaoAstral());
    }

    /**
     * Método responsável por escolher, aleatoriamente, a ação de combate da Feiticeira. 
     * Ela tem 65% de aplicar golpe normal sobre o alvo; e 35% de utilizar a Habilidade Especial.
     */
    public iacaoDeCombate escolherAcao(iCombatente alvo) {
        Random random = new Random();
        int flagAtac = random.nextInt(0, 100);
        if (flagAtac <= 65) { return this.listaCombates.get(0); }
        else {return this.listaCombates.get(1); }
    }

}

