abstract class HeroiAbstrato extends PersonagemAbstrato {
    
    protected int nivel;
    protected int experiencia;
    protected  String fraseDeEfeito;
    protected  String fraseVitoria;

    public HeroiAbstrato(String n, int pv, int f, String fraseEfeito, String fraseVitoria) {
        super(n, pv, f);
        this.nivel = 0;
        this.experiencia = 0;
        this.fraseDeEfeito = fraseEfeito;
        this.fraseVitoria = fraseVitoria;
    }

    public void ganhaNivel() {
        this.nivel ++;
        this.PontosDeVida += this.nivel;
        System.out.println("*** Subiu de nível ***");
    }

    public void ganhaExperiencia(int xp) {
        
        this.experiencia += xp;

        switch(this.nivel) {
            case 0: 
                if (this.experiencia >= 2) {
                    this.experiencia = 0;
                    ganhaNivel();
                }
                break;
            
            case 1:
                if (this.experiencia >= 7) {
                    this.experiencia = 0;
                    ganhaNivel();
                }
                break;

            case 2:
                if (this.experiencia >= 20) {
                    this.experiencia = 0;
                    ganhaNivel();
                }
                break;
        }
    }

    @Override
    public String toString() {

        String resultado = super.toString();
        resultado = resultado + "Nível: " + this.nivel + "\n";
        resultado = resultado + "Experiência: " + this.experiencia;

        return resultado;
    }

    @Override
    public void exibirStatus() {
        System.out.println(this);
    }

    public abstract void usarHabilidadeEspecial(PersonagemAbstrato alvo);

}
