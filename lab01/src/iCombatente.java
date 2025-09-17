public interface iCombatente {

    String getNome();
    Boolean estaVivo();
    void receberDano(int dano);
    void receberCura(int cura);
    iacaoDeCombate escolherAcao(iCombatente alvo);


}
