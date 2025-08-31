import java.util.Random;

public  class MonarcaEsqueleto extends MonstroAbstrato  {
    
    public MonarcaEsqueleto(){
        super("Monarca Esqueleto", 10, 15, 20, "Monarca Esqueleto: SUCUMBA AO MEU INFERNO, CRIATURA INFELIZ", "Monarca Esqueleto: SEUS DEUSES TE ESQUECERAM.","lab01/imagens-texto/monarca-esqueleto.txt");

    }


    public void atacar(PersonagemAbstrato alvo){
        int dano = 0;
        Random random = new Random();
        int numAleat = random.nextInt(0,100);

        if (numAleat<75) {
            dano = this.forca;
            alvo.receberDano(dano);
            System.out.println(this.fraseDeEfeito);
        }

    }
    
}