import java.util.ArrayList;
import java.util.List;

public class Kit implements ItemLoja {
    private String nome;
    private List<ItemLoja> itens;

    public Kit(String nome) {
        this.nome = nome;
        this.itens = new ArrayList<>();
    }

    public void adicionar(ItemLoja item) {
        itens.add(item);
    }

    public void remover(ItemLoja item) {
        itens.remove(item);
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public double getPreco() {
        double total = 0;
        for (ItemLoja item : itens) {
            total += item.getPreco();
        }
        return total;
    }

    @Override
    public void exibir(String prefixo) {
        System.out.println(prefixo + "+ Kit: " + nome + " | Total: R$ " + getPreco());
        for (ItemLoja item : itens) {
            item.exibir(prefixo + "  ");
        }
    }
}