class HabilidadeAntesdeVidaSuficiente extends Exception {
    @Override
        public String getMessage(){
            return "Tentativa do uso da habilidade antes da vida suficiente ";
        }
}