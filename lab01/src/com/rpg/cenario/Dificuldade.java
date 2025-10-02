package com.rpg.cenario;
import java.util.Random;

import com.rpg.itens.Amuleto;
import com.rpg.itens.Arma;
import com.rpg.itens.Coroa;
import com.rpg.itens.Pedra;
import com.rpg.itens.Punhal;

public enum Dificuldade {
    
    FACIL (0, 0, 45, 75, 100, 0),
    NORMAL (1, 2, 33, 66, 100, 0),
    DIFICIL (3, 5, 15, 45, 85, 100);

    private final int adVida; // Adicional de vida para todos os monstros
    private final int adForca; // Adicional de força para todos os monstros
    private final int probAmuleto;
    private final int probCoroa;
    private final int probPedra;
    private final int probPunhal;

    private Dificuldade(int adVida, int adForca, int probAmuleto, int probCoroa, int probPedra, int probPunhal) {
        this.adVida = adVida;
        this.adForca = adForca;
        this.probAmuleto = probAmuleto;
        this.probCoroa = probCoroa;
        this.probPedra = probPedra;
        this.probPunhal = probPunhal;
    }

    /*
     * Método "getter" para adicional de vida
     */
    int AdicionalVida() {return this.adVida; }

    /*
     * Método "getter" para adicional de força
     */
    int AdicionalForca() {return this.adForca; }

    Arma [] ArmasParaLargar() {
        
        Arma result[];
        result = new Arma[3];

        Random random = new Random();
        int numAleat;

        for (int cont=0; cont<3; cont++)  {    
            numAleat = random.nextInt(0, 101);
            if (numAleat <= this.probPedra){ result[cont] = new Pedra(); }
            else if (numAleat <= this.probPunhal) {result[cont] = new Punhal(); }
            else if (numAleat <= this.probAmuleto) {result[cont] = new Amuleto(); }
            else if (numAleat <= this.probCoroa) { result[cont] = new Coroa(); }
        }
        return result;
    }
}
