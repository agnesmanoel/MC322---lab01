package com.rpg.cenario;
import com.rpg.personagens.HeroiAbstrato;

/**
 * Interface para todos os eventos do jogo. Eles devem ser acionados 
 * uma vez que o gatilho particular é ativado.
 * 
 * @author : Agnes Manoel e Bernardo Nascimento
 */
public interface InterfaceEvento {
    boolean verificarGatilho(HeroiAbstrato usuario);
    void executar(HeroiAbstrato usuario);
}
