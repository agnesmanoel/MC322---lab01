package com.rpg.personagens;
import com.rpg.combate.AtaqueMonstroSimples;
import com.rpg.combate.InterfaceAcaoDeCombate;
import com.rpg.itens.Arma;
import com.rpg.itens.Punhal;

/**
 * Classe concreta que implementa MonstroAbstrato, representando um Fantasma.
 * 
 * @author : Agnes Manoel e Bernardo Nascimento
 */
public  class Fantasma extends MonstroAbstrato  {
    
    /** 
     * Método construtor de Fantasma. O objeto é inicializado com 5 de vida, 2 de força e 
     * 2 xp concedidos.
     */
    public Fantasma(int adVida, int adForca, Arma[] armasParaLargar){
        super("Fantasma", 5, 2, 2, 
              "- Fantasma: SiNta A mInHa DoOoOr...",
              "- Fantasma: comPaRtiLHE da mInHa SolIdÃOoOo!",
              "- Fantasma: SoOomOos as almas daqueles deixaAaAdoOos na mAsMoOorra... e AgoRaA qUeREmOs... VINGANÇA!",
              "lab01/imagens-texto/fantasma.txt",
              new Punhal(),
              """
              * Fantasma *
               ___________________________________________________________  
              | Seres acometidos por uma paralisante melancolia, e ainda  | 
              | assim, inflados por uma incessante sede de vingança.      |
              | Temendo a solidão do esquecimento, costumam vagar em      |
              | bandos.                                                   |
              |___________________________________________________________|""", 
              adVida,
              adForca);
        this.listaDeArmasParaLargar = armasParaLargar.clone();
        this.listaCombates.add(new AtaqueMonstroSimples());

    }

    /**
     * Método responsável por escolher ação de combate do Fantasma.
     * Por enquanto, ele, tal como todos os demais monstros, possuem apenas
     * um ataque disponível.
     */
    public InterfaceAcaoDeCombate escolherAcao(InterfaceCombatente alvo) {
        return this.listaCombates.get(0);
        
    }

    
    
}
