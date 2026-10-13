public class Questao {
    private String id;
    private String enunciado;
    private int pontos;
    public Questao(String id, String enunciado, int pontos){
        this.id = id;
        this.enunciado = enunciado;
        this.pontos = pontos;
    }
    public Questao copiar(){
        return new Questao(this.id, this.enunciado, this.pontos);
    }
    public String getId() {
        return id;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }
    @Override
    public String toString(){
        return "ID: "+this.id+"\nPontos: "+this.pontos+"\nEnunciado: "+this.enunciado+"\n";
    }
}
