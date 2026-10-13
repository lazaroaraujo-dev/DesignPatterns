import java.util.ArrayList;
import java.util.List;

public abstract class Relatorio {
    protected Exportador exportador;
    protected List<ItemRelatorio> itens;

    public Relatorio(Exportador exportador){
        this.exportador = exportador;
        this.itens = new ArrayList<>();
    }
    public void adicionarItem(ItemRelatorio item){
        itens.add(item);
    }
    protected double calcularTotal(){
        double total = 0;
        for (int i = 0; i < itens.size(); i++){
            total += itens.get(i).getValor();
        }
        return total;
    }
    protected List<ItemRelatorio> filtraritensDetalhados(boolean detalhado){
        if (detalhado) {
            return itens;
        } else {
            List<ItemRelatorio> lista = new ArrayList();
            for (int i = 0; i < itens.size(); i++){
                if (itens.get(i).getValor()>=100){
                    lista.add(itens.get(i));
                }
            }
            return lista;
        }
    }
    public abstract void gerar();
}
