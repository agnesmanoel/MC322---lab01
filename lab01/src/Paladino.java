import java.util.Random;

public class Paladino extends HeroiAbstrato{
    
    private int AuraDaJustica; 

    public Paladino (String n) {
        super(n, 20, 10);
        this.AuraDaJustica = 1;
    }


    public int atacar(PersonagemAbstrato alvo) {

        int dano = 0;
        Random random = new Random();
        int num_aleat = random.nextInt(0, 100);

        

        return dano;
    }

    public int usarHabilidadeEspecial(PersonagemAbstrato alvo) {
        
        int dano = 0;

        return dano;
    }

}
