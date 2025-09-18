public interface iCombatente {

    String getNome();
    boolean estaVivo();
    void receberDano(int dano);
    void receberCura(int cura);
    iacaoDeCombate escolherAcao(iCombatente alvo);


}
