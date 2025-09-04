import java.util.Random;

public  class Esqueleto extends MonstroAbstrato  {
    
    public Esqueleto(){
        super("Esqueleto", 10, 5, 7, "- Esqueleto: HA! HA! HA! Ossada sinistra!", "- Esqueleto: Torne-se um de NÓS!","- Esqueleto: Eu  não terei pena de torná-lo um dos nossos!","lab01/imagens-texto/esqueleto.txt");
    }

    public void atacar(PersonagemAbstrato alvo){
        
        int dano;
        Random random = new Random();
        int numAleat = random.nextInt(0,100);

        if (numAleat<60) {
            dano = this.forca;
            alvo.receberDano(dano);
            
            System.out.println(this.nome + ": *** ACERTOU O ATAQUE ***");
            if (alvo.estaVivo()) {System.out.println(this.fraseDeEfeito);}
            else {System.out.println(this.fraseVitoria);}
        }

        else {System.out.println(this.nome + ": *** ERROU O ATAQUE ***"); }

    }
    
}