import java.util.Random;

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
    }

    /* 
     * Método concreto de ataque simples. A chance de acerto é 75%.
     * Já o dano é dado pela força do objeto.
     */
    public void atacar(PersonagemAbstrato alvo) {
        
        int dano;
        Random random = new Random();
        int numAleat = random.nextInt(0,100);

        if (numAleat<75) {
            dano = this.forca + this.arma.dano;
            alvo.receberDano(dano);

            System.out.println(this.nome + ": *** ACERTOU O ATAQUE ***"); 
            if (alvo.estaVivo()) {System.out.println(this.fraseDeEfeito);}
            else {System.out.println(this.fraseVitoria);}
            
        }

        else {System.out.println(this.nome + ": *** ERROU O ATAQUE ***"); }
    }
    
}