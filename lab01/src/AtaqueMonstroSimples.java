import java.util.Random;

public class AtaqueMonstroSimples implements iacaoDeCombate {

    // Método de ataque simples dos monstros.
    public void executar(iCombatente usuario, iCombatente alvo) {
        MonstroAbstrato monstro = (MonstroAbstrato) usuario;

        int dano;
        Random random = new Random();
        int numAleat = random.nextInt(0,100);

        if (numAleat<75) { // definir melhor aqui o numAleat
            dano = monstro.forca + monstro.arma.dano;
            alvo.receberDano(dano);

            System.out.println(monstro.nome + ": *** ACERTOU O ATAQUE : " + dano + " Dano ***"); 
            if (alvo.estaVivo()) {System.out.println(monstro.fraseDeEfeito);}
            else {System.out.println(monstro.fraseVitoria);}
            
        }

        else {System.out.println(monstro.nome + ": *** ERROU O ATAQUE ***"); }
    }
        
    }
    
