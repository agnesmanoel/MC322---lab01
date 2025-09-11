import java.util.Random;

public class ConstrutorDeCenario {
    
    public static Fase[] gerarFases(int nFases) {

        Fase[] result = new Fase[nFases];
        int nivel = 0;
        String descricao;
        MonstroAbstrato[] listaMonstro;
        int nMonstro;
        Random random = new Random();
        int numAleat;

        for (int cont=0; cont < nFases; cont ++) {

            // O nível de dificuldade da fase sempre será encrementado por 1
            nivel ++;

            // O número de monstros é duas vezes o nível da fase
            nMonstro = 2*nivel;
            listaMonstro = new MonstroAbstrato[nMonstro];

            if (nivel == 1) {
                descricao = "O herói avança em direção ao castelo, e se depara com bizarras criaturas nos portões do reino...";
                listaMonstro[0] = new Fantasma();
                listaMonstro[1] = new Fantasma();
            }
            else if (nivel == nFases) {
                descricao = "O aventureiro chega ao fim de sua jornada, rumo ao seu último e derradeiro desafio!";
                for (int i = 0; i < nMonstro; i++) {
                    numAleat = random.nextInt(0, 100);
                    if (numAleat < 30) {
                        listaMonstro[i] = new Fantasma();
                    }
                    else if (30 <= numAleat && numAleat < 60) {
                        listaMonstro[i] = new Esqueleto();
                    }
                    else {
                        listaMonstro[i] = new MonarcaEsqueleto();
                    }
                }
            }
            else if (nivel == 2) {
                descricao = "O vencedor de Tchutchuwamako adentra na antiga masmorra do reino, palco de almas e atrocidades há muito esquecidas...";
                listaMonstro[0] = new Fantasma();
                listaMonstro[1] = new Fantasma();
                listaMonstro[2] = new Esqueleto();
                listaMonstro[3] = new Esqueleto();
            }
            else {
                descricao = "Escuridão adentro, o guerreiro destemido avança ainda mais pelos corredores da masmorra.";
                for (int i = 0; i < nMonstro; i++) {
                    numAleat = random.nextInt(0, 100);
                    if (numAleat < 30) {
                        listaMonstro[i] = new Fantasma();
                    }
                    else if (30 <= numAleat && numAleat < 85) {
                        listaMonstro[i] = new Esqueleto();
                    }
                    else {
                        listaMonstro[i] = new MonarcaEsqueleto();
                    }
                }
            }

            result[cont] = new Fase(nivel, listaMonstro, descricao);

        }

        return result;
    }

}
