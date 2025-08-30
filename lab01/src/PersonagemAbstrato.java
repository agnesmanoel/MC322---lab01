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
        this.PontosDeVida -= dano;
    }

    public void exibirStatus() {
       String resultado = "Nome: "+this.nome+"\n";
       resultado = resultado+"Vida: "+this.PontosDeVida+"\n";
       resultado = resultado+"Força: "+this.forca+"\n"; 

       System.out.println(resultado);
    }

    public  String getNome(){
        return this.nome;
    }

    public abstract void atacar(PersonagemAbstrato alvo);

}
