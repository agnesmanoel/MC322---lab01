import java.util.Random;

public  class Esqueleto extends MonstroAbstrato  {
    
    public Esqueleto(){
        super("Esqueleto", 10, 5, 7, "Esqueleto: HA HA HA OSSADA SINISTRA!!!!!", "Esqueleto: TORNE-SE UM DE NÓS","lab01/imagens-texto/esqueleto.txt");

    }


    public void atacar(PersonagemAbstrato alvo){
        int dano = 0;
        Random random = new Random();
        int numAleat = random.nextInt(0,100);

        if (numAleat<60) {
            dano = this.forca;
            alvo.receberDano(dano);
            System.out.println(this.fraseDeEfeito);
        }

    }
    
}