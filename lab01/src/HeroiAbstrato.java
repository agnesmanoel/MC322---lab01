abstract class HeroiAbstrato extends PersonagemAbstrato {
    
    private String nome;
    private int PontosDeVida;
    private int forca;
    private int nivel;
    private int experiencia;

    public HeroiAbstrato(String n, int pv, int f) {
        super(n, pv, f);
        this.nivel = 0;
        this.experiencia = 0;
    }

    public void ganhaExperiencia(int xp) {
        this.experiencia += xp;
    }

    // public void exibirStatus() {

    // }

    public abstract void usarHabilidadeEspecial(PersonagemAbstrato alvo);

}
