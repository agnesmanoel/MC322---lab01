import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class ConstrutorDeCenarioFixo implements iGeradorDeFases{
    
    static  String nomePersonagem;

    public ConstrutorDeCenarioFixo(HeroiAbstrato heroi) {
        nomePersonagem = heroi.getNome();
    }

    public static void Intro() {

        printaCastelo();
        System.out.println("||| Introdução |||\n");
        System.out.println("O castelo está em perigo.... precisamos de alguém para nos salvar.");
        System.out.println("O reino de Tchutchuwamako foi tomado pelas mais sombrias critaturas do inferno.");
        System.out.println("Sabendo disso, "+nomePersonagem+" muniu-se de suas melhores armas e correu para salvar o castelo\n\n");
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
    
    public static void Confronto(HeroiAbstrato heroi, MonstroAbstrato monstro) {
        
        Random random = new Random();
        int numAlet = random.nextInt(0, 3);
        String text;
        switch (numAlet) {
            case 0:
                text = " se depara com o horripilante ";
                break;
            case 1:
                text = " encontra o decrépito e maligno ";
                break;
            default:
                text = " agora fica face à face com ";
                break;
        }

        System.out.println(nomePersonagem + text + monstro.getNome() + ".");
        monstro.apresentacao();

        printSideBySideBottom(heroi.getFileImage(), monstro.getFileImage(), "             ");

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

    public static void Status(HeroiAbstrato heroi) {
        System.out.println("\r\n------");
        System.out.println("Status");
        System.out.println("\r------");
        System.out.println(heroi);
    }

    public static void Status(HeroiAbstrato heroi, MonstroAbstrato monstro) {
        System.out.println("\r\n------");
        System.out.println("Status");
        System.out.println("\r------");
        printSideBySideUp(heroi.toString(), monstro.toString(), "       ");
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
                    
    public static void Vitoria() {
        System.out.println("Ao menos por ora, " + nomePersonagem + " mostrou-se capaz de livrar o reino Tchutchuwamako das legiões infernais.");
        System.out.println("Os assustados moradores agora podem voltar a dormir em paz...");
        System.out.println("\n\n");
        System.out.println("            ***************");
        System.out.println("            *** VITÓRIA ***");
        System.out.println("            ***************");
        System.out.println("\n\n");
    }

    public static void Derrota() {
        System.out.println("As legiões infernais se apoderam do reino de Tchutchuwamako, dando início a um reinado de terror e trevas...");
        System.out.println(nomePersonagem+" fracassou em seu juramento de proteção...");
        System.out.println("\n\n");
        System.out.println("            *****************");
        System.out.println("            *** GAME OVER ***");
        System.out.println("            *****************");
        System.out.println("\n\n");
    }

    @Override
    public iFase[] gerar(int quantidadeDeFases) {

        iFase[] result = new iFase[quantidadeDeFases];
        int nivel = 0;
        TipoDeCenario cenario;
        MonstroAbstrato[] listaMonstro;
        int nMonstro;
        Random random = new Random();
        int numAleat;

        for (int cont=0; cont < quantidadeDeFases; cont ++) {

            // O nível de dificuldade da fase sempre será encrementado por 1
            nivel ++;

            // O número de monstros é duas vezes o nível da fase
            nMonstro = 2*nivel;
            listaMonstro = new MonstroAbstrato[nMonstro];

            if (nivel == 1) {
                cenario = TipoDeCenario.PORTÃO;
                listaMonstro[0] = new Fantasma();
                listaMonstro[1] = new Fantasma();
            }
            else if (nivel == quantidadeDeFases) {
                cenario = TipoDeCenario.MASMORRA;
                for (int i = 0; i < nMonstro; i++) {
                    numAleat = random.nextInt(0, 100);
                    if (numAleat < 30) {
                        listaMonstro[i] = new Fantasma();
                    }
                    else if (30 <= numAleat && numAleat < 60) {
                        listaMonstro[i] = new Esqueleto();
                    }
                    else {
                        listaMonstro[i] = new MonarcaEsqueleto();
                    }
                }
            }
            else if (nivel == 2) {
                cenario = TipoDeCenario.MASMORRA;
                listaMonstro[0] = new Fantasma();
                listaMonstro[1] = new Fantasma();
                listaMonstro[2] = new Esqueleto();
                listaMonstro[3] = new Esqueleto();
            }
            else {
                cenario = TipoDeCenario.MASMORRA;
                for (int i = 0; i < nMonstro; i++) {
                    numAleat = random.nextInt(0, 100);
                    if (numAleat < 30) {
                        listaMonstro[i] = new Fantasma();
                    }
                    else if (30 <= numAleat && numAleat < 85) {
                        listaMonstro[i] = new Esqueleto();
                    }
                    else {
                        listaMonstro[i] = new MonarcaEsqueleto();
                    }
                }
            }

            result[cont] = new FaseCombate(cenario, listaMonstro);

        }

        return result;
    }

}
