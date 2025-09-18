import java.util.Random;

public class Feiticeira extends HeroiAbstrato {

    protected int PocaoAstral;

    /** 
     * Método construtor de Feiticeira. O objeto é inicializado com 16 de vida e 8 de força.
     */
    public Feiticeira () {
        super("Feiticeira", 16, 8, "- Feiticeira: Você erra ao me subestimar, aberração...", "- Feiticeira: A Natureza não terá piedade dos seus restos!","lab01/imagens-texto/feiticeira.txt");
        this.PocaoAstral = 1;
        this.listaCombates.add(new AtaqueHeroiSimples());
        this.listaCombates.add(new AtaquePocaoAstral());
    }

    /**
     * Método aprimorado para incrementar habilidade especial a cada nível completado.
     */
    public iacaoDeCombate escolherAcao(iCombatente alvo) {
        Random random = new Random();
        int flagAtac = random.nextInt(0, 100);
        if (flagAtac <= 65) { return this.listaCombates.get(0); }
        else { return this.listaCombates.get(1); }
    }

}

