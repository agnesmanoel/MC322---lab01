package com.rpg.game;
import com.rpg.cenario.ConstrutorDeCenarioFixo;
import com.rpg.cenario.Dificuldade;
import com.rpg.cenario.Emboscada;
import com.rpg.cenario.FaseCombate;
import com.rpg.cenario.InterfaceEvento;
import com.rpg.combate.InterfaceAcaoDeCombate;
import com.rpg.exception.HabilidadeAntesdeVidaSuficiente;
import com.rpg.personagens.Feiticeira;
import com.rpg.personagens.HeroiAbstrato;
import com.rpg.personagens.MonstroAbstrato;
import com.rpg.personagens.Paladino;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws Exception {

        //Instanciando objetos de Heróis Concretos
        Paladino personagemPaladino = new Paladino();
        Feiticeira personagemFeiticeira = new Feiticeira();

        // Instancindo emboscada
        InterfaceEvento emboscada = new Emboscada();

        // Gerador de números aleatórios
        Random random = new Random();

        // Seleciona-se aleatoriamente a Feiticeira ou o Paladino para a camapnha de RPG
        boolean bool = random.nextBoolean();
        HeroiAbstrato personagemAtual = personagemPaladino;
        if(bool){
            personagemAtual = personagemFeiticeira;
        }

        //Instanciando ConstrutorDeCenarioFixo (isto é, o gerador de fases)
        ConstrutorDeCenarioFixo geradorFases = new ConstrutorDeCenarioFixo(personagemAtual);

        boolean flag = geradorFases.Menu();
        if (! flag) { return; }
        
        // Variáveis de contagem
        int contRound;

        // Lista de fases
        Dificuldade difi = geradorFases.EscolherDificuldade();
        int nFases = geradorFases.EscolherNumeroDeFases(); // Número de fases
        FaseCombate FaseAtual;
       FaseCombate[] listaFases = geradorFases.gerar(nFases, difi);
     
        // Exibe a introdução da campanha
        geradorFases.Intro();
        Thread.sleep(1800);

        // Loop principal percorrendo a lista de fases
        for (int contFase = 0; contFase < nFases; contFase++) {

            System.out.println("||| Fase: " + (contFase+1) + " / " + nFases + " |||\n\n");

            FaseAtual = (FaseCombate) listaFases[contFase];
            MonstroAbstrato monstroAtual;

            // Início da fase e exibição dos status do personagem
            FaseAtual.iniciar(personagemAtual);
            Thread.sleep(1500);
            geradorFases.Status(personagemAtual);
            Thread.sleep(900);
            
            // Loop interno percorrendo a lista de monstros
            while (! FaseAtual.isConcluida()) {

                monstroAtual = FaseAtual.listaMonstros[FaseAtual.getContMonstro()];

                // Introduz-se o combate entre personagem e monstro
                System.out.println("|| Monstro: " + (FaseAtual.getContMonstro()+1) + " ||\n");
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
                    InterfaceAcaoDeCombate ataque = personagemAtual.escolherAcao(monstroAtual);
                    
                    try {
                        ataque.executar(personagemAtual,monstroAtual);
                    } catch (HabilidadeAntesdeVidaSuficiente e) {
                        System.out.println(personagemAtual.getNome()+": *** VIDA MAIOR QUE EXIGIDO PARA HABILIDADE ESPECIAL ***");
                    }

                    
                    // Caso o monstro sobreviva ao ataque, tem a chance de contra-atacar
                    if(monstroAtual.estaVivo()){
                        InterfaceAcaoDeCombate ataqueMonstro = monstroAtual.escolherAcao(personagemAtual);
                        ataqueMonstro.executar(monstroAtual, personagemAtual);
                    } 

                    Thread.sleep(700);

                    // Exibem-se os status de cada combatente
                    geradorFases.Status(personagemAtual, monstroAtual);
                    Thread.sleep(1200);
                }               

                // Checagem se a emboscada é ativada
                emboscada.executar(personagemAtual);
                Thread.sleep(1200);

                // Avança-se para o próximo monstro da fase, caso o haja
                FaseAtual.avanca();

                // Checagem se o herói continua vivo após o fim da batalha
                if(! personagemAtual.estaVivo()){ geradorFases.Derrota(); return; } 

                flag = geradorFases.posTurno(personagemAtual, monstroAtual);
                if (! flag) { return; }
                
            }

        }

        // Checagem se o herói continua vivo após as três fases da campanha
        if(personagemAtual.estaVivo()){ geradorFases.Vitoria(); }
    }

}
