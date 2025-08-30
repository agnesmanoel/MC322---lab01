abstract class MonstroAbstrato extends PersonagemAbstrato{
    
    private int xpConcedido;

    public MonstroAbstrato(String n, int pv, int f, int xp) {
        super(n, pv, f);
        this.xpConcedido = xp;
    }

    // public void exibirStatus () {

    // }
}
