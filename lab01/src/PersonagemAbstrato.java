abstract class PersonagemAbstrato {
    
    protected  String nome;
    protected  int PontosDeVida;
    protected  int forca;

    public PersonagemAbstrato(String n, int pv, int f) {
        this.nome = n;
        this.PontosDeVida = pv;
        this.forca = f;
    }

    public void receberDano(int dano) {
        this.PontosDeVida = Math.max(this.PontosDeVida - dano, 0);
    }

    @Override
    public String toString() {

       String resultado = "Nome: "+this.nome+"\n";
       resultado = resultado+"Vida: "+this.PontosDeVida+"\n";
       resultado = resultado+"Força: "+this.forca+"\n";

        return resultado;
    }

    public void exibirStatus() {
       System.out.println(this);
    }

    public  String getNome(){
        return this.nome;
    }

    public boolean estaVivo(){
        return this.PontosDeVida > 0;
    }

    public abstract void atacar(PersonagemAbstrato alvo);

}
