abstract class MonstroAbstrato extends PersonagemAbstrato{
    
    public int xpConcedido;
    public String fraseDeEfeito;
    public String fraseVitoria;



    public MonstroAbstrato(String n, int pv, int f, int xp, String fraseEfeito, String fraseVitoria) {
        super(n, pv, f);
        this.xpConcedido = xp;
        this.fraseDeEfeito = fraseEfeito;
        this.fraseVitoria = fraseVitoria;
    }

    // public void exibirStatus () {

    // }
}
