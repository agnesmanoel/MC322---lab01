abstract public class Arma implements iItem {

    protected String nome;
    protected  int dano;
    protected  int minNivel;
    protected  String intro;

    public Arma(String nome, int d, int n, String txt) {
        this.nome = nome;
        this.dano = d;
        this.minNivel = n;
        this.intro = txt;
    }

    @Override
    public String getNome() {
        return this.nome;
    }
    
}
