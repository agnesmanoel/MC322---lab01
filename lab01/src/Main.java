
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws Exception {
        
        //Instanciando objetos de Heróis Concretos
        Paladino personagemPaladino = new Paladino();
        Feiticeira personagemFeiticeira = new Feiticeira();
        
        //Instanciando objetos de Vilões Concretos
        Fantasma personagemFantasma = new Fantasma();
        Esqueleto personagemEsqueleto = new Esqueleto();
        MonarcaEsqueleto personagemMonarcaEsqueleto = new MonarcaEsqueleto();

        // Criando listas de Monstros e Heróis
        MonstroAbstrato[] arrayMonstros =  {personagemFantasma, personagemEsqueleto, personagemMonarcaEsqueleto};
        ArrayList<MonstroAbstrato> listaMonstro = new ArrayList<>(Arrays.asList(arrayMonstros));

        // Gerador de números aleatórios
        Random random = new Random();

        // Seleciona-se aleatoriamente a Feiticeira ou o Paladino para a camapnha de RPG
        boolean bool = random.nextBoolean();
        HeroiAbstrato personagemAtual = personagemPaladino;
        if(bool){
            personagemAtual = personagemFeiticeira;
        }
        
        // Variáveis aleatórias
        int numAleat;
        int flagAtac;

        // Variáveis de contagem
        int contRound;
        int fase=0;

        // Exibe a introdução da campanha
        historia(personagemAtual, null, fase);

        while(!listaMonstro.isEmpty()){    
            
            fase++;        
            
            // Escolhe-se um monstro aleatoriamente para cada fase
            numAleat = 0;
            if(listaMonstro.size()>1) {
                numAleat = random.nextInt(0, (listaMonstro.size()-1)); 
            } 
            MonstroAbstrato monstroAtual = listaMonstro.get(numAleat);
            
            // Exibe-se a respectiva fase
            historia(personagemAtual, monstroAtual, fase);

            // monstroAtual.printImagem();
            printSideBySideBottom(personagemAtual.getFileImage(), monstroAtual.getFileImage(), "             ");

            // Iniciam-se os turnos de batalha, até que um dos combatentes perca
            contRound = 0;
            while(personagemAtual.estaVivo() && monstroAtual.estaVivo()){

                contRound ++;

                // Exibe-se o respectivo turno
                System.out.println("|Turno: " + contRound + "|\r\n");
                Thread.sleep(1500);

                // Seleciona-se aleatoriamente o tipo de ataque do herói
                flagAtac = random.nextInt(0, 100);
                if (flagAtac <= 65) { personagemAtual.atacar(monstroAtual); }
                else { personagemAtual.usarHabilidadeEspecial(monstroAtual); }
                
                // Caso o monstro sobreviva ao ataque, tem a chance de contra-atacar
                if(monstroAtual.estaVivo()){ monstroAtual.atacar(personagemAtual); } 

                Thread.sleep(2000);

                // Exibem-se os status de cada combatente
                System.out.println("\r\n------");
                System.out.println("Status");
                System.out.println("\r------");
                Thread.sleep(1500);
                printSideBySideUp(personagemAtual.toString(), monstroAtual.toString(), "       ");
                Thread.sleep(2500);
                
            }

            contRound = 0;

            // Checagem se o herói continua vivo após o fim da batalha
            if(personagemAtual.estaVivo()){ listaMonstro.remove(numAleat); } 
            else {
                historia(personagemAtual, monstroAtual, -2);
                break;
            }


        }

        // Checagem se o herói continua vivo após as três fases da campanha
        if(personagemAtual.estaVivo()){
            historia(personagemAtual, null, -1);
        }
    }

    // Método criado para alinhar, por cima, blocos de texto - isto é, os personagens
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

    // Método criado para alinhar, por baixo, blocos de texto
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

    // Método criado para exibir diferentes trechos da campanha
    public static void historia(HeroiAbstrato heroiAtual, MonstroAbstrato monstroAtual, int fase) throws InterruptedException{
        
        String nomeMonstro;
        if (monstroAtual == null) {nomeMonstro = "";}
        else {nomeMonstro = monstroAtual.getNome();}
        String nomeHeroi = heroiAtual.getNome();

        switch (fase) {

            case 0: 
                printaCastelo();
                System.out.println("|||Introdução|||\n");
                Thread.sleep(1700);
                System.out.println("O castelo está em perigo.... precisamos de alguém para nos salvar.");
                Thread.sleep(1200);
                System.out.println("O reino de Tchutchuwamako foi tomado pelas mais sombrias critaturas do inferno.");
                Thread.sleep(1200);
                System.out.println("Sabendo disso, "+heroiAtual.getNome()+" muniu-se de suas melhores armas e correu para salvar o castelo\n\n");
                Thread.sleep(2000);
                break;
            case 1:
                System.out.println("|||Fase: 1/3|||\n");
                Thread.sleep(1700);
                System.out.println("O primeiro monstro que " + nomeHeroi + " encontra, na porta da frente do castelo é " + nomeMonstro + ".");
                Thread.sleep(1200);
                monstroAtual.apresentacao();
                Thread.sleep(1200);
                System.out.println("Temendo pela integridade do reino, " +nomeHeroi+ " inicia a luta.");
                Thread.sleep(2000);
                break;
            case 2:
                System.out.println("|||Fase: 2/3|||\n");
                Thread.sleep(1700);
                System.out.println("O segundo monstro que " + nomeHeroi + " encontra no corredor da masmorra do castelo é " + nomeMonstro + ".");
                Thread.sleep(1200);
                monstroAtual.apresentacao();
                Thread.sleep(1200);
                System.out.println("Então, pelo bem dos moradores do seu querido reino, " +nomeHeroi+ " inicia a segunda luta.");
                Thread.sleep(2000);
                break;
            case 3:
                System.out.println("|||Fase: 3/3|||\n");
                Thread.sleep(1700);
                System.out.println("O terceiro monstro que " + nomeHeroi + " encontra na masmorra do castelo é " + nomeMonstro + ".");
                Thread.sleep(1200);
                monstroAtual.apresentacao();
                Thread.sleep(1200);
                System.out.println("Depois de um longo suspiro, " +nomeHeroi+ " reúne suas últimas forças e inicia a batalha final.");
                Thread.sleep(2000);
                break;
            case -1:
                System.out.println("Ao menos por ora, " + nomeHeroi + " mostrou-se capaz de livrar o reino Tchutchuwamako das legiões infernais.");
                System.out.println("Os assustados moradores agora podem voltar a dormir em paz...");
                Thread.sleep(1700);
                System.out.println("\n\n");
                System.out.println("            ***************");
                System.out.println("            *** VITÓRIA ***");
                System.out.println("            ***************");
                System.out.println("\n\n");
                break;
            case -2:
                System.out.println("As legiões infernais se apoderam do reino de Tchutchuwamako, dando início a um reinado de terror e trevas...");
                System.out.println(nomeHeroi+" fracassou em seu juramento de proteção...");
                Thread.sleep(1700);
                System.out.println("\n\n");
                System.out.println("            *****************");
                System.out.println("            *** GAME OVER ***");
                System.out.println("            *****************");
                System.out.println("\n\n");
                break;
        }     
    }

    // Método criado para exibir a ilustração do castelo
    public static void printaCastelo(){
                String image = "\n";
        File imagem = new File("lab01/imagens-texto/castelo.txt");
        try {
            Scanner reader = new Scanner(imagem);
            while(reader.hasNextLine()){
                String linha = reader.nextLine();
                image = image + linha + "\n";
            } reader.close();
         }  
            catch (FileNotFoundException e) {
                System.out.println("erro ao achar URL AAAAAAAAAAAAAAA");
                return;

        }

        System.out.println(image);
    }
}
