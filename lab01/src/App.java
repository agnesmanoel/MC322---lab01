
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;


public class App {
    public static void main(String[] args) throws Exception {
        
        //Instanciando objetos heróis
        Paladino personagemPaladino = new Paladino();
        Feiticeira personagemFeiticeira = new Feiticeira();
        
        //Instanciando objetos vilões
        Fantasma personagemFantasma = new Fantasma();
        Esqueleto personagemEsqueleto = new Esqueleto();
        MonarcaEsqueleto personagemMonarcaEsqueleto = new MonarcaEsqueleto();

        // Criando lista de monstros e herois
        MonstroAbstrato[] arrayMonstros =  {personagemFantasma, personagemEsqueleto, personagemMonarcaEsqueleto};
        ArrayList<MonstroAbstrato> listaMonstro = new ArrayList<>(Arrays.asList(arrayMonstros));


        HeroiAbstrato[] arrayHerois = {personagemPaladino, personagemFeiticeira};

        // gerador de números aleatórios
        Random random = new Random();
        
        // Variáveis aleatórias
        int numAleat;
        int flagAtac;

        while(!listaMonstro.isEmpty()){
            
            // escolhendo um monstro aleatoriamente
            numAleat = 0;
            if(listaMonstro.size()>1) {
                numAleat = random.nextInt(0, (listaMonstro.size()-1)); 
            } 
            MonstroAbstrato monstroAtual = listaMonstro.get(numAleat);

            // enquanto um dos combatentes estiverem vivos
            while(personagemPaladino.estaVivo() && monstroAtual.estaVivo()){

                flagAtac = random.nextInt(0, 100);
                if (flagAtac <= 70) { personagemPaladino.atacar(monstroAtual); }
                else { personagemPaladino.usarHabilidadeEspecial(monstroAtual); }
                
                if(monstroAtual.estaVivo()){ monstroAtual.atacar(personagemPaladino); } 

                System.out.println("\n----------------------");
                personagemPaladino.exibirStatus();
                monstroAtual.exibirStatus();
                System.out.println("----------------------\n");

                Thread.sleep(3000);
                
            } 

            if(personagemPaladino.estaVivo()){ listaMonstro.remove(numAleat); } 
            else {
                System.out.println("    *****************");
                System.out.println("    *** GAME OVER ***");
                System.out.println("    *****************");
                break;
            }


        }

        if(personagemPaladino.estaVivo()){
            System.out.println("    ***************");
            System.out.println("    *** VITÓRIA ***");
            System.out.println("    ***************");
        }
    }
}
