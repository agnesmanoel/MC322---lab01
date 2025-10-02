package com.rpg.exception;
public class mininsuficienteArma extends Exception {
    @Override
        public String getMessage(){
            return "Tentativa do uso de capturar a arma sem nivel suficiente ";
        }
}