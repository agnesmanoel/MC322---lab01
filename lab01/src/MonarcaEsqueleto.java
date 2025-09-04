import java.util.Random;

public  class MonarcaEsqueleto extends MonstroAbstrato  {
    
    public MonarcaEsqueleto() {
        super("Monarca Esqueleto", 10, 15, 20, "- Monarca Esqueleto: Sucumba ao meu inferno, criatura infeliz...", "- Monarca Esqueleto: Seus deuses te ESQUECERAM!","- Monarca Esqueleto: Curve-se ao meu império do mal ou morra desejando piedade de sua alma.", "lab01/imagens-texto/monarca-esqueleto.txt");
    }

    public void atacar(PersonagemAbstrato alvo) {
        
        int dano;
        Random random = new Random();
        int numAleat = random.nextInt(0,100);

        if (numAleat<75) {
            dano = this.forca;
            alvo.receberDano(dano);

            System.out.println(this.nome + ": *** ACERTOU O ATAQUE ***"); 
            if (alvo.estaVivo()) {System.out.println(this.fraseDeEfeito);}
            else {System.out.println(this.fraseVitoria);}
            
        }

        else {System.out.println(this.nome + ": *** ERROU O ATAQUE ***"); }
    }
    
}