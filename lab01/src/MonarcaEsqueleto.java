import java.util.Random;

public  class MonarcaEsqueleto extends MonstroAbstrato  {
    
    public MonarcaEsqueleto(){
        super("Monarca Esqueleto", 10, 15, 20, "SUCUMBA AO MEU INFERNO, CRIATURA INFELIZ", "SEUS DEUSES TE ESQUECERAM.");

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