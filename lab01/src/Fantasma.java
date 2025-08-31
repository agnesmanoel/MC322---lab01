import java.util.Random;

public  class Fantasma extends MonstroAbstrato  {
    
    public Fantasma(){
        super("Fantasma", 5, 2, 2, "Fantasma: SINTA A MINHA DOR!!!!!","Fantasma: COMPARTILHE DA MINHA SOLIDÃO","lab01/imagens-texto/fantasma.txt");

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
