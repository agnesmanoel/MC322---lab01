import java.util.Random;

public  class Esqueleto extends MonstroAbstrato  {
    
    public Esqueleto(){

        super("Esqueleto", 10, 5, 7, "- Esqueleto: HA HA HA OSSADA SINISTRA!!!!!", "- Esqueleto: TORNE-SE UM DE NÓS","EU ESQUELETO NÃO TEREI PENA DE TE FAZER UM DE MIM","lab01/imagens-texto/esqueleto.txt");

    }


    public void atacar(PersonagemAbstrato alvo){
        
        int dano;
        Random random = new Random();
        int numAleat = random.nextInt(0,100);

        if (numAleat<60) {
            dano = this.forca;
            alvo.receberDano(dano);
            
            if (alvo.estaVivo()) {System.out.println(this.fraseDeEfeito);}
            else {System.out.println(this.fraseVitoria);}
        }

        else {System.out.println(this.nome + ": *** ERROU O ATAQUE ***"); }

    }
    
}