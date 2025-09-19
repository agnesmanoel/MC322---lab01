
public  class MonarcaEsqueleto extends MonstroAbstrato  {
    
    /** 
     * Método construtor de Monarca Esqueleto. O objeto é inicializado com 10 de vida, 15 de força e 
     * 20 xp concedidos.
     */
    public MonarcaEsqueleto() {
        super("Monarca Esqueleto", 10, 15, 20, "- Monarca Esqueleto: Sucumba ao meu inferno, criatura infeliz...", "- Monarca Esqueleto: Seus deuses te ESQUECERAM!","- Monarca Esqueleto: Curve-se ao meu império do mal ou morra desejando piedade de sua alma.", "lab01/imagens-texto/monarca-esqueleto.txt", new Coroa());
        this.listaDeArmasParaLargar[0] = new Coroa();
        this.listaDeArmasParaLargar[1] = new Amuleto();
        this.listaDeArmasParaLargar[2] = new Amuleto();
        this.listaCombates.add(new AtaqueMonstroSimples());
    }

    /**
     * Método responsável por escolher ação de combate do Monarca.
     * Por enquanto, ele, tal como todos os demais monstros, possuem apenas
     * um ataque disponível.
     */
    public iacaoDeCombate escolherAcao(iCombatente alvo) { return this.listaCombates.get(0); } 

}