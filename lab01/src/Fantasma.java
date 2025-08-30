import java.util.Random;

public  class Fantasma extends MonstroAbstrato  {
    
    public Fantasma(){
        super("Fantasma", 5, 2, 2, "SINTA A MINHA DOR!!!!!","COMPARTILHE DA MINHA SOLIDÃO");

    }


    public void atacar(PersonagemAbstrato alvo){
        int dano = 0;
        Random random = new Random();
        int numAleat = random.nextInt(0,100);

        if (numAleat<40) {
            dano = this.forca;
            alvo.receberDano(dano);
            System.out.println(this.fraseDeEfeito);
        }

    }
    
}
