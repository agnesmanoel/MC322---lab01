abstract class MonstroAbstrato extends PersonagemAbstrato{
    
    private String nome;
    private int PontosDeVida;
    private int forca;
    private int xpConcedido;

    public MonstroAbstrato(String n, int pv, int f, int xp) {
        super(n, pv, f);
        this.xpConcedido = xp;
    }

    // public void exibirStatus () {

    // }
}
