package com.rpg.cenario;
import com.rpg.personagens.HeroiAbstrato;
import com.rpg.personagens.MonstroAbstrato;

public class FaseCombate implements iFase {

    private TipoDeCenario cenario;
    public MonstroAbstrato[] listaMonstros;
    private int contMonstro;

    /**
     * Método construtor da fase de combate.
     * @param cenario : cenário em que se passa a fase;
     * @param listaMonstros : lista de monstros a serem enfrentados.
     */
    public FaseCombate(TipoDeCenario cenario, MonstroAbstrato[] listaMonstros) {
        this.cenario = cenario;
        this.listaMonstros = listaMonstros;
        this.contMonstro = 0;
    }

    /**
     * Método responsável por dar início à fase, introduzindo o cenário.
     * @param heroi : heroi da campanha.
     */
    public void iniciar(HeroiAbstrato heroi) {
        
        String aux_txt = "";
        for (int i = 0; i < this.getTipoDeCenario().length(); i++) {
            aux_txt = aux_txt + "*";
        }

        String txt = aux_txt + "\n";
        txt = txt + this.getTipoDeCenario() + "\n";
        txt = txt + aux_txt + "\n";
        System.out.println(txt);

        this.cenario.aplicarEfeitos(heroi);

    }

    /**
     * Método responsável por número de monstros já entrentados na fase.
     * @return this.contMonstro 
     */
    public int getContMonstro () { return this.contMonstro; }

    /**
     * Método responsável por encrementar o número de monstros enfrentados.
     */
    public void avanca() { this.contMonstro ++; }

    /**
     * Método responsável por verificar se a fase já foi concluída.
     * Casoo contador de monstros enfrentados se equipare ao número monstros totais,
     * ela é concluída.
     */
    public boolean isConcluida() { return this.contMonstro == this.listaMonstros.length; }

    /**
     * Método retorna tipo de cenário em que a fase se passa.
     */
    public String getTipoDeCenario() { return this.cenario.toString(); }
    
}
