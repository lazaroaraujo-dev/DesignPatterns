import java.util.ArrayList;
import java.util.List;

public class RelatorioVendas extends Relatorio{
    public RelatorioVendas(Exportador exportador) {
        super(exportador);
    }
    @Override
    public void gerar() {
        gerar(true);
    }
    public void gerar(boolean detalhado) {
        List<ItemRelatorio> lista = filtraritensDetalhados(detalhado);

        double total = 0;
        for (int i = 0; i < lista.size(); i++){
            total += lista.get(i).getValor();
        }

        exportador.exportar("Relatório de Vendas", lista, total);
    }
}
