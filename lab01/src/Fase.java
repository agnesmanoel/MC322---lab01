  // Método criado para exibir diferentes trechos da campanha

public class Fase {

    int nivel;
    MonstroAbstrato[] listaMonstros;
    String descricao;

    public Fase(int nivel, MonstroAbstrato[] vetorMonstro,String descricao) {
      this.nivel = nivel;
      this.descricao= descricao;
      this.listaMonstros = vetorMonstro;   
    }

    @Override
    public String toString() { return this.descricao; }
 }
