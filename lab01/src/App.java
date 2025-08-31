
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;


public class App {
    public static void main(String[] args) throws Exception {
        
        //Instanciando objetos heróis
        Paladino personagemPaladino = new Paladino();
        Feiticeira personagemFeiticeira = new Feiticeira();

        //Instanciando objetos vilões
        Fantasma personagemFantasma = new Fantasma();
        Esqueleto personagemEsqueleto = new Esqueleto();
        MonarcaEsqueleto personagemMonarcaEsqueleto = new MonarcaEsqueleto();

        // Criando lista de monstros e herois
        MonstroAbstrato[] arrayMonstros =  {personagemFantasma, personagemEsqueleto, personagemMonarcaEsqueleto};
        ArrayList<MonstroAbstrato> listaMonstro = new ArrayList<>(Arrays.asList(arrayMonstros));


        HeroiAbstrato[] arrayHerois = {personagemPaladino, personagemFeiticeira};
        System.out.println("\n");



        while(!listaMonstro.isEmpty()){
            int numAleat = 0;

            // escolhendo um monstro aleatoriamente
            if(listaMonstro.size()>1) {
            Random random = new Random();
            numAleat = random.nextInt(0, (listaMonstro.size()-1)); 
            } 
            MonstroAbstrato monstroAtual = listaMonstro.get(numAleat);

            // enquanto um dos personagens estiverem vivos
            while(personagemPaladino.PontosDeVida>0 && monstroAtual.PontosDeVida>0){
                personagemPaladino.atacar(monstroAtual);
                if(monstroAtual.PontosDeVida>0){
                    monstroAtual.atacar(personagemPaladino);
                } 

                System.out.println("\n");
                System.out.println("----------------------");
                personagemPaladino.exibirStatus();
                monstroAtual.exibirStatus();
                System.out.println("----------------------");
                
            } 

            if(personagemPaladino.PontosDeVida>0){
                listaMonstro.remove(numAleat);
            } else {
                System.out.println("game over");
                break;
            }





        }

        // for (int i = 0; i < 2; i++) {
        //     MonstroAbstrato monstroAtual = arrayMonstros[i];
        //     while(arrayHerois[0].PontosDeVida>0 && arrayMonstros[i].PontosDeVida>0){
        //         personagemPaladino.atacar(monstroAtual);
        //         if(monstroAtual.PontosDeVida>0){
        //             arrayMonstros[i].atacar(personagemPaladino);
        //         }
        //         System.out.println("----------------------");
        //         personagemPaladino.exibirStatus();
        //         monstroAtual.exibirStatus();
        //         System.out.println("-----------------------");
        //     }
        //     if(personagemPaladino.PontosDeVida <= 0){
        //         System.out.println("game over");
        //         break;
        //     }
            
        // }





        if(personagemPaladino.PontosDeVida>0){
            System.out.println("vc venceu");
        }



    }
}
