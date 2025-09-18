
public  class Esqueleto extends MonstroAbstrato  {
    
    /** 
     * Método construtor de Esqueleto. O objeto é inicializado com 10 de vida, 5 de força e 
     * 7 xp concedidos.
     */
    public Esqueleto(){
        super("Esqueleto", 10, 5, 7, "- Esqueleto: HA! HA! HA! Ossada sinistra!", "- Esqueleto: Torne-se um de NÓS!","- Esqueleto: Eu  não terei pena de torná-lo um dos nossos!", "lab01/imagens-texto/esqueleto.txt", new Amuleto());
        this.listaDeArmasParaLargar[0] = new Punhal();
        this.listaDeArmasParaLargar[1] = new Amuleto();
        this.listaDeArmasParaLargar[2] = new Pedra();
        this.listaCombates.add(new AtaqueMonstroSimples());
    }

    public iacaoDeCombate escolherAcao(iCombatente alvo) {
        return this.listaCombates.get(0);
        
    }
    
}