public class App {
    public static void main(String[] args) throws Exception {
        
        //Instanciando objetos heróis
        Paladino personagemPaladino = new Paladino();
        Feiticeira personagemFeiticeira = new Feiticeira();
        
        //Instanciando objetos vilões
        Fantasma personagemFantasma = new Fantasma();
        Esqueleto personagemEsqueleto = new Esqueleto();
        MonarcaEsqueleto personagemMonarcaEsqueleto = new MonarcaEsqueleto();

        MonstroAbstrato[] arrayMonstros =  {personagemFantasma, personagemEsqueleto, personagemMonarcaEsqueleto};

        for (int i = 0; i <= 2; i++) {
            while(personagemPaladino.PontosDeVida>0 && arrayMonstros[i].PontosDeVida>0){
                personagemPaladino.atacar(arrayMonstros[i]);
                if(arrayMonstros[i].PontosDeVida>0){
                    arrayMonstros[i].atacar(personagemPaladino);
                }
                System.out.println("\n-----------------------");
                personagemPaladino.exibirStatus();
                arrayMonstros[i].exibirStatus();
                System.out.println("-----------------------\n");
            }

            if(personagemPaladino.PontosDeVida <= 0){
                System.out.println("game over");
                break;
            }
            
        }

        if(personagemPaladino.PontosDeVida>0){
            System.out.println("VOCE VENCEU");
        }
    }
}
