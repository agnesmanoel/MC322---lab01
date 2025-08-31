abstract class MonstroAbstrato extends PersonagemAbstrato{
    
    protected int xpConcedido;
    protected String fraseDeEfeito;
    protected String fraseVitoria;

    public MonstroAbstrato(String n, int pv, int f, int xp, String fraseEfeito, String fraseVitoria) {
        super(n, pv, f);
        this.xpConcedido = xp;
        this.fraseDeEfeito = fraseEfeito;
        this.fraseVitoria = fraseVitoria;
    }
    
    @Override
    public String toString() {

        String resultado = super.toString();
        resultado = resultado + "Experiência concedida: " + this.xpConcedido;

        return "\n" + resultado;
    }

    @Override
    public void exibirStatus() {
        System.out.println(this);
    }

}
