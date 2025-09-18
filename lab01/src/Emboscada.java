public class Emboscada implements iEvento {

    public boolean verificarGatilho(HeroiAbstrato usuario) {
        if(usuario.sorte <= 50){return true;} else {return false;}
        
    }

    public void executar(HeroiAbstrato usuario) {
        if(verificarGatilho(usuario)){
        int dano = 3;
        System.out.println("E de repente, enquanto " + usuario.getNome() + " andava pelo castelo em ruínas, sentiu uma dor latejante em seus pés...");
        System.out.println("Ao olhar para baixo, viu que espinhos embebidos de veneno atravessavam a sola de seu pé.");
        System.out.println(usuario.getNome() + ": *** MAUS AGOUROS : " + dano + " Dano ***\n");
        usuario.receberDano(dano);}
    }



}
