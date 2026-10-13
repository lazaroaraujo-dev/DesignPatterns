public class Produto implements ItemLoja {
    private String nome;
    private double preco;

    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public double getPreco() {
        return preco;
    }

    @Override
    public void exibir(String prefixo) {
        System.out.println(prefixo + "- Produto: " + nome + " | Preço: R$ " + preco);
    }
}