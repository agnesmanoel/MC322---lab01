
public  class Fantasma extends MonstroAbstrato  {
    
    /** 
     * Método construtor de Fantasma. O objeto é inicializado com 5 de vida, 2 de força e 
     * 2 xp concedidos.
     */
    public Fantasma(){
        super("Fantasma", 5, 2, 2, "- Fantasma: SiNta A mInHa DoOoOr...","- Fantasma: comPaRtiLHE da mInHa SolIdÃOoOo!","- Fantasma: SoOomOos as almas daqueles deixaAaAdoOos na mAsMoOorra... e AgoRaA qUeREmOs... VINGANÇA!","lab01/imagens-texto/fantasma.txt", new Punhal());
        this.listaDeArmasParaLargar[0] = new Punhal();
        this.listaDeArmasParaLargar[1] = new Pedra();
        this.listaDeArmasParaLargar[2] = new Pedra();
        this.listaCombates.add(new AtaqueMonstroSimples());

    }

    public iacaoDeCombate escolherAcao(iCombatente alvo) {
        return this.listaCombates.get(0);
        
    }

    
    
}
