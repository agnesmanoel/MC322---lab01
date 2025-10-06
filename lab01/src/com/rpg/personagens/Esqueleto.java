package com.rpg.personagens;


import com.rpg.combate.AtaqueMonstroSimples;
import com.rpg.combate.InterfaceAcaoDeCombate;
import com.rpg.itens.Amuleto;
import com.rpg.itens.Arma;

/**
 * Classe concreta que implementa MonstroAbstrato, representando um Esqueleto.
 * 
 * @author : Agnes Manoel e Bernardo Nascimento
 */
public  class Esqueleto extends MonstroAbstrato  {
    
    /** 
     * Método construtor de Esqueleto. O objeto é inicializado com 10 de vida, 5 de força e 
     * 7 xp concedidos.
     */
    public Esqueleto(int adVida, int adForca, Arma[] armasParaLargar){
        super("Esqueleto", 10, 5, 7, 
              "- Esqueleto: HA! HA! HA! Ossada sinistra!",
              "- Esqueleto: Torne-se um de NÓS!",
              "- Esqueleto: Eu  não terei pena de torná-lo um dos nossos!",
              "lab01/imagens-texto/esqueleto.txt", 
              new Amuleto(), 
              """
              * Esqueleto *
               ___________________________________________________________  
              | Os membros mais ardilosos do exército de monstros. São    |
              | motivados pela sede de sangue, e pelo desejo de           |
              | transformar mais vidas inocentes em aberrações de puro    |
              | cálcio e trevas.                                          |
              |___________________________________________________________|""", 
              adVida,
             adForca);
        this.listaDeArmasParaLargar = armasParaLargar.clone();
        this.listaCombates.add(new AtaqueMonstroSimples());
    }

    /**
     * Método responsável por escolher ação de combate do Esqueleto.
     * Por enquanto, ele, tal como todos os demais monstros, possuem apenas
     * um ataque disponível.
     */
    public InterfaceAcaoDeCombate escolherAcao(InterfaceCombatente alvo) {
        return this.listaCombates.get(0);
        
    }
    
}