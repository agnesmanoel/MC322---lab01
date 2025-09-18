public class FaseCombate implements iFase {

    private TipoDeCenario cenario;
    protected MonstroAbstrato[] listaMonstros;
    private int contMonstro;

    public FaseCombate(TipoDeCenario cenario, MonstroAbstrato[] listaMonstros) {
        this.cenario = cenario;
        this.listaMonstros = listaMonstros;
        this.contMonstro = 0;
    }

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

    public int getContMonstro () {
        return this.contMonstro;
    }

    public void avanca() {
        this.contMonstro ++;
    }

    public boolean isConcluida() {
        return this.contMonstro == this.listaMonstros.length;
    }

    public String getTipoDeCenario() {
        return this.cenario.toString();
    }
    
}
