
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


        //HeroiAbstrato[] arrayHerois = {personagemPaladino, personagemFeiticeira};
        System.out.println("\n");

        // gerador de números aleatórios
        Random random = new Random();
        
        // Variáveis aleatórias
        int numAleat;
        int flagAtac;
        int contRound;

        while(!listaMonstro.isEmpty()){
            
            // escolhendo um monstro aleatoriamente
            numAleat = 0;
            if(listaMonstro.size()>1) {
                numAleat = random.nextInt(0, (listaMonstro.size()-1)); 
            } 
            MonstroAbstrato monstroAtual = listaMonstro.get(numAleat);
            // monstroAtual.printImagem();
            printSideBySideBottom(personagemPaladino.getFileImage(), monstroAtual.getFileImage(), "             ");
            Thread.sleep(2500);

            contRound = 0;

            // enquanto um dos combatentes estiverem vivos
            while(personagemPaladino.estaVivo() && monstroAtual.estaVivo()){

                contRound ++;
                System.out.println("|Turno: " + contRound + "|\r\n");

                flagAtac = random.nextInt(0, 100);
                if (flagAtac <= 75) { personagemPaladino.atacar(monstroAtual); }
                else { personagemPaladino.usarHabilidadeEspecial(monstroAtual); }
                
                if(monstroAtual.estaVivo()){ monstroAtual.atacar(personagemPaladino); } 

                Thread.sleep(1500);
                
                System.out.println("\r\n------");
                System.out.println("Status");
                System.out.println("\r------");

                printSideBySideUp(personagemPaladino.toString(), monstroAtual.toString(), "       ");
                
                Thread.sleep(4500);
                
            }

            contRound = 0;

            if(personagemPaladino.estaVivo()){ listaMonstro.remove(numAleat); } 
            else {
                System.out.println("\n\n");
                System.out.println("            *****************");
                System.out.println("            *** GAME OVER ***");
                System.out.println("            *****************");
                System.out.println("\n\n");
                break;
            }


        }

        if(personagemPaladino.estaVivo()){
            System.out.println("\n\n");
            System.out.println("            ***************");
            System.out.println("            *** VITÓRIA ***");
            System.out.println("            ***************");
            System.out.println("\n\n");
        }
    }

    public static void printSideBySideUp(String block1, String block2, String separator) {
        
        String[] lines1 = block1.split("\\R"); // "\\R" handles various line terminators
        String[] lines2 = block2.split("\\R");

        int maxLength = Math.max(lines1.length, lines2.length);
        int maxline = 0;

        for (int i = 0; i < maxLength; i++) {
                if (maxline < lines1[i].length()) {maxline = lines1[i].length();}
            }

        for (int i = 0; i < maxLength; i++) {

            String line1 = (i < lines1.length) ? lines1[i] : "";
            String line2 = (i < lines2.length) ? lines2[i] : "";

            String new_sep = separator;
            for (int j = 0; j < maxline - line1.length(); j++) {
                new_sep = new_sep+" ";
            }

            System.out.println(line1 + new_sep + line2);

            if (i == maxLength - 1) {
                System.out.println("\n");
            }
        }
    }

    public static void printSideBySideBottom(String block1, String block2, String separator) {
        
        String[] lines1 = block1.split("\\R"); // "\\R" handles various line terminators
        String[] lines2 = block2.split("\\R");

        int maxLength = Math.max(lines1.length, lines2.length);
        int maxline = 0;
        String new_block = "";
        
        for (int i = 0; i < lines1.length; i++) {
                if (maxline < lines1[i].length()) {maxline = lines1[i].length();}
            }
        
        for (int i = 0; i < Math.abs(lines1.length - lines2.length); i++) {
            new_block = "\n" + new_block;
        }
        if (lines1.length < lines2.length) { 
            new_block = new_block + block1;
            lines1 = new_block.split("\\R");
        }
        else { 
            new_block = new_block + block2;
            lines2 = new_block.split("\\R");
        }

        for (int i = 0; i < maxLength; i++) {

            String line1 = (i < lines1.length) ? lines1[i] : "";
            String line2 = (i < lines2.length) ? lines2[i] : "";

            if (i == maxLength - 1) {
                String new_sep = "";
                for (int j = 0; j < separator.length(); j++) {
                    new_sep = new_sep+"_";
                }
                for (int j = 0; j < maxline - line1.length(); j++) {
                    new_sep = new_sep+"_";
                }
                System.out.println(line1 + new_sep + line2);
                System.out.println("\n");
            }
            else {
                String new_sep = separator;
                for (int j = 0; j < maxline - line1.length(); j++) {
                    new_sep = new_sep+" ";
                }
                System.out.println(line1 + new_sep + line2);
            }
            
        }
    }
}
