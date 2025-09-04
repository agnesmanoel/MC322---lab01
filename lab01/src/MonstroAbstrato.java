

abstract class MonstroAbstrato extends PersonagemAbstrato{
    
    protected int xpConcedido;
    protected String fraseDeEfeito;
    protected String fraseVitoria;
    protected String fraseApresentacao; 
    protected String imageURL;

    public MonstroAbstrato(String n, int pv, int f, int xp, String fraseEfeito, String fraseVitoria, String fraseApresentacao, String URL) {
        super(n, pv, f, URL);
        this.xpConcedido = xp;
        this.fraseDeEfeito = fraseEfeito;
        this.fraseVitoria = fraseVitoria;
        this.fraseApresentacao = fraseApresentacao; 
    }
    
    @Override
    public String toString() {

        String resultado = super.toString();
        resultado = resultado + "Experiência concedida: " + this.xpConcedido;
        resultado = "\n--------------------------\n" + resultado + "\n\n--------------------------\n";

        return resultado;
    }

    @Override
    public void exibirStatus() {
        System.out.println(this);
    }

    public void apresentacao () {
        System.out.println(this.fraseApresentacao);
    }

}
