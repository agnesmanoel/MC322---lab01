import java.util.Random;

public class Main {
    public static void main(String[] args) throws Exception {
        
        //Instanciando objetos de Heróis Concretos
        Paladino personagemPaladino = new Paladino();
        Feiticeira personagemFeiticeira = new Feiticeira();

        // Gerador de números aleatórios
        Random random = new Random();

        // Seleciona-se aleatoriamente a Feiticeira ou o Paladino para a camapnha de RPG
        boolean bool = random.nextBoolean();
        HeroiAbstrato personagemAtual = personagemPaladino;
        if(bool){
            personagemAtual = personagemFeiticeira;
        }

        //Instanciando ConstrutorDeCenarioFixo
        ConstrutorDeCenarioFixo geradorFases = new ConstrutorDeCenarioFixo(personagemAtual);
        
        // Variável aleatória responsável por definir o tipo de ataque (normal ou habilidade especial) 
        // utilizado pelo personagem.
        int flagAtac;

        // Variáveis de contagem
        int contRound;

        // Lista de fases
        int nFases = 2; // Número de fases
        // Fase FaseAtual;
        // Fase[] listaFases = ConstrutorDeCenario.gerarFases(nFases, personagemAtual.getNome());  
        FaseCombate FaseAtual;
        iFase[] listaFases = geradorFases.gerar(nFases);
     
        // Exibe a introdução da campanha
        // ConstrutorDeCenario.Intro(personagemAtual.getNome());
        geradorFases.Intro();
        Thread.sleep(1800);

        // Loop principal percorrendo a lista de fases
        for (int contFase = 0; contFase < nFases; contFase++) {

            FaseAtual = (FaseCombate) listaFases[contFase];
            MonstroAbstrato monstroAtual;

            // System.out.println(FaseAtual);
            FaseAtual.iniciar(personagemAtual);
            Thread.sleep(1500);
            // ConstrutorDeCenario.Status(personagemAtual);
            geradorFases.Status(personagemAtual);
            Thread.sleep(900);
            
            // Loop interno percorrendo a lista de monstros
            while (! FaseAtual.isConcluida()) {

                monstroAtual = FaseAtual.listaMonstros[FaseAtual.getContMonstro()];

                // Introduz-se o combate entre personagem e monstro
                System.out.println("|| Monstro: " + (FaseAtual.getContMonstro()+1) + " ||\n");
                // ConstrutorDeCenario.Confronto(personagemAtual, monstroAtual);
                geradorFases.Confronto(personagemAtual, monstroAtual);
                Thread.sleep(1200);

                contRound = 0;

                // Loop mais interno percorrendo os turnos da batalha
                while(personagemAtual.estaVivo() && monstroAtual.estaVivo()){

                    contRound ++;

                    // Exibe-se o respectivo turno
                    System.out.println("| Turno: " + contRound + " |\r\n");
                    Thread.sleep(800);

                    // Ataque do herói
                    iacaoDeCombate ataque = personagemAtual.escolherAcao(monstroAtual);
                    ataque.executar(personagemAtual,monstroAtual);

                    
                    // Caso o monstro sobreviva ao ataque, tem a chance de contra-atacar
                    if(monstroAtual.estaVivo()){
                        iacaoDeCombate ataqueMonstro = monstroAtual.escolherAcao(personagemAtual);
                        ataqueMonstro.executar(monstroAtual, personagemAtual);
                     } 

                    Thread.sleep(700);

                    // Exibem-se os status de cada combatente
                    ConstrutorDeCenario.Status(personagemAtual, monstroAtual);
                    Thread.sleep(1200);
                    
                }

                FaseAtual.avanca();

                // Checagem se o herói continua vivo após o fim da batalha
                if(! personagemAtual.estaVivo()){ ConstrutorDeCenario.Derrota(personagemAtual.getNome()); return; } 
                
            }

        }

        // Checagem se o herói continua vivo após as três fases da campanha
        if(personagemAtual.estaVivo()){ ConstrutorDeCenario.Vitoria(personagemAtual.getNome()); }
    }

}
