import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

abstract class PersonagemAbstrato {
    
    protected  String nome;
    protected  int PontosDeVida;
    protected  int forca;
    protected String imagemURL;

    public PersonagemAbstrato(String n, int pv, int f, String URL) {
        this.nome = n;
        this.PontosDeVida = pv;
        this.forca = f;
        this.imagemURL = URL;
    }

    public void receberDano(int dano) {
        this.PontosDeVida -= dano;
    }

    @Override
    public String toString() {

       String resultado = "Nome: "+this.nome+"\n";
       resultado = resultado+"Vida: "+this.PontosDeVida+"\n";
       resultado = resultado+"Força: "+this.forca+"\n";

        return resultado;
    }

    public String getFileImage(){
        String image = "\n";
        File imagem = new File(this.imagemURL);
        try {
            Scanner reader = new Scanner(imagem);
            while(reader.hasNextLine()){
                String linha = reader.nextLine();
                image = image + linha + "\n";
            } reader.close();
         }  
            catch (FileNotFoundException e) {
                System.out.println("erro ao achar URL AAAAAAAAAAAAAAA");
                return "erro nao foi possivel ler";

        }

        return image;

    }

    public void printImagem(){
        System.out.println(getFileImage());
    }



    public void exibirStatus() {
       System.out.println(this);
    }

    public  String getNome(){
        return this.nome;
    }

    public abstract void atacar(PersonagemAbstrato alvo);

}
