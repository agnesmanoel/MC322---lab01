import java.util.Random;

public  class Fantasma extends MonstroAbstrato  {
    
    /** 
     * Método construtor de Fantasma. O objeto é inicializado com 5 de vida, 2 de força e 
     * 2 xp concedidos.
     */
    public Fantasma(){
        super("Fantasma", 5, 2, 2, "- Fantasma: SiNta A mInHa DoOoOr...","- Fantasma: comPaRtiLHE da mInHa SolIdÃOoOo!","- Fantasma: SoOomOos as almas daqueles deixaAaAdoOos na mAsMoOorra... e AgoRaA qUeREmOs... VINGANÇA!","lab01/imagens-texto/fantasma.txt", new Punhal());

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
            
            System.out.println(this.nome + ": *** ACERTOU O ATAQUE ***");
            if (alvo.estaVivo()) {System.out.println(this.fraseDeEfeito);}
            else {System.out.println(this.fraseVitoria);}
        }
        
        else {System.out.println(this.nome + ": *** ERROU O ATAQUE ***"); }

    }
    
}
