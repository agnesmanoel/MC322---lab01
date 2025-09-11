  // Método criado para exibir diferentes trechos da campanha

public class Fase {

    int nivel;
    MonstroAbstrato[] listaMonstros;
    String descricao;

    public Fase(int nivel, MonstroAbstrato[] vetorMonstro,String descricao) {
      this.nivel = nivel;
      this.descricao= descricao;
      this.listaMonstros = vetorMonstro;   
    }

    @Override
    public String toString() {
        return this.descricao;
    }

  }
  
    
//   } (HeroiAbstrato heroiAtual, MonstroAbstrato[] listaMonstro, int fase) throws InterruptedException{
        
//     String nomeMonstro;
//     if (monstroAtual == null) {nomeMonstro = "";}
//     else {nomeMonstro = monstroAtual.getNome();}
//     String nomeHeroi = heroiAtual.getNome();

//     switch (fase) {

//         case 0: 
//             printaCastelo();
//             System.out.println("|||Introdução|||\n");
//             Thread.sleep(1700);
//             System.out.println("O castelo está em perigo.... precisamos de alguém para nos salvar.");
//             Thread.sleep(1200);
//             System.out.println("O reino de Tchutchuwamako foi tomado pelas mais sombrias critaturas do inferno.");
//             Thread.sleep(1200);
//             System.out.println("Sabendo disso, "+heroiAtual.getNome()+" muniu-se de suas melhores armas e correu para salvar o castelo\n\n");
//             Thread.sleep(2000);
//             break;
//         case 1:
//             System.out.println("|||Fase: 1/3|||\n");
//             Thread.sleep(1700);
//             System.out.println("O primeiro monstro que " + nomeHeroi + " encontra, na porta da frente do castelo é " + nomeMonstro + ".");
//             Thread.sleep(1200);
//             monstroAtual.apresentacao();
//             Thread.sleep(1200);
//             System.out.println("Temendo pela integridade do reino, " +nomeHeroi+ " inicia a luta.");
//             Thread.sleep(2000);
//             break;
//         case 2:
//             System.out.println("|||Fase: 2/3|||\n");
//             Thread.sleep(1700);
//             System.out.println("O segundo monstro que " + nomeHeroi + " encontra no corredor da masmorra do castelo é " + nomeMonstro + ".");
//             Thread.sleep(1200);
//             monstroAtual.apresentacao();
//             Thread.sleep(1200);
//             System.out.println("Então, pelo bem dos moradores do seu querido reino, " +nomeHeroi+ " inicia a segunda luta.");
//             Thread.sleep(2000);
//             break;
//         case 3:
//             System.out.println("|||Fase: 3/3|||\n");
//             Thread.sleep(1700);
//             System.out.println("O terceiro monstro que " + nomeHeroi + " encontra na masmorra do castelo é " + nomeMonstro + ".");
//             Thread.sleep(1200);
//             monstroAtual.apresentacao();
//             Thread.sleep(1200);
//             System.out.println("Depois de um longo suspiro, " +nomeHeroi+ " reúne suas últimas forças e inicia a batalha final.");
//             Thread.sleep(2000);
//             break;
//         case -1:
//             System.out.println("Ao menos por ora, " + nomeHeroi + " mostrou-se capaz de livrar o reino Tchutchuwamako das legiões infernais.");
//             System.out.println("Os assustados moradores agora podem voltar a dormir em paz...");
//             Thread.sleep(1700);
//             System.out.println("\n\n");
//             System.out.println("            ***************");
//             System.out.println("            *** VITÓRIA ***");
//             System.out.println("            ***************");
//             System.out.println("\n\n");
//             break;
//         case -2:
//             System.out.println("As legiões infernais se apoderam do reino de Tchutchuwamako, dando início a um reinado de terror e trevas...");
//             System.out.println(nomeHeroi+" fracassou em seu juramento de proteção...");
//             Thread.sleep(1700);
//             System.out.println("\n\n");
//             System.out.println("            *****************");
//             System.out.println("            *** GAME OVER ***");
//             System.out.println("            *****************");
//             System.out.println("\n\n");
//             break;
//     }     
// }

// // Método criado para exibir a ilustração do castelo
// public static void printaCastelo(){
//             String image = "\n";
//     File imagem = new File("lab01/imagens-texto/castelo.txt");
//     try {
//         Scanner reader = new Scanner(imagem);
//         while(reader.hasNextLine()){
//             String linha = reader.nextLine();
//             image = image + linha + "\n";
//         } reader.close();
//      }  
//         catch (FileNotFoundException e) {
//             System.out.println("erro ao achar URL AAAAAAAAAAAAAAA");
//             return;

//     }

//     System.out.println(image);
// }
// }
