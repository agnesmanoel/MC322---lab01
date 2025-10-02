package com.rpg.cenario;
import com.rpg.personagens.HeroiAbstrato;

public class Emboscada implements InterfaceEvento {

    /* 
     * Método responsável por verificar atiavação da emboscada.
     * Caso a sorte do personagem está abaixo de 35%, ela é
     * ativada.
     */
    public boolean verificarGatilho(HeroiAbstrato usuario) {
        return usuario.sorte <= 35;
    }

    /*
     * Método responsável por executar, de fato, a emboscada.
     * O persoagem leva 1 de dano ao pisar em um espinho 
     * envenenado.
     */
    public void executar(HeroiAbstrato usuario) {
        if(verificarGatilho(usuario)){
            int dano = 1;
            System.out.println("| Evento |\r\n");
            System.out.println("E de repente, enquanto " + usuario.getNome() + " andava pelo castelo em ruínas, sentiu uma dor latejante em seus pés...");
            System.out.println("Ao olhar para baixo, viu que espinhos embebidos de veneno atravessavam a sola de seu pé.");
            System.out.println(usuario.getNome() + ": *** MAUS AGOUROS : " + dano + " Dano ***\n");
            usuario.receberDano(dano);
        }
    }



}
