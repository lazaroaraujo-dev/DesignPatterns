public class ItemRelatorio {
    private String descricao;
    private double valor;

    public ItemRelatorio(String descricao, double valor){
        this.descricao = descricao;
        this.valor = valor;
    }
    public String getDescricao(){
        return descricao;
    }
    public double getValor(){
        return valor;
    }
}
