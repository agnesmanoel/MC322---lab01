import java.util.Random;

public  class Esqueleto extends MonstroAbstrato  {
    
    /** 
     * Método construtor de Esqueleto. O objeto é inicializado com 10 de vida, 5 de força e 
     * 7 xp concedidos.
     */
    public Esqueleto(){
        super("Esqueleto", 10, 5, 7, "- Esqueleto: HA! HA! HA! Ossada sinistra!", "- Esqueleto: Torne-se um de NÓS!","- Esqueleto: Eu  não terei pena de torná-lo um dos nossos!", "lab01/imagens-texto/esqueleto.txt", new Amuleto());
        this.listaDeArmasParaLargar[0] = new Punhal();
        this.listaDeArmasParaLargar[1] = new Amuleto();
        this.listaDeArmasParaLargar[2] = new Pedra();
    }

    /* 
     * Método concreto de ataque simples. A chance de acerto é 60%.
     * Já o dano é dado pela força do objeto.
     */
    public void atacar(PersonagemAbstrato alvo){
        
        int dano;
        Random random = new Random();
        int numAleat = random.nextInt(0,100);

        if (numAleat<60) {
            dano = this.forca+ this.arma.dano;
            alvo.receberDano(dano);
            
            System.out.println(this.nome + ": *** ACERTOU O ATAQUE : " + dano + " Dano ***");
            if (alvo.estaVivo()) {System.out.println(this.fraseDeEfeito);}
            else {System.out.println(this.fraseVitoria);}
        }

        else {System.out.println(this.nome + ": *** ERROU O ATAQUE ***"); }

    }
    
}