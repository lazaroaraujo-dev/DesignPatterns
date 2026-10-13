import java.util.List;

public class RelatorioFinanceiro extends Relatorio{

    public RelatorioFinanceiro(Exportador exportador) {
        super(exportador);
    }
    @Override
    public void gerar() {
        gerar(true);
    }
    public void gerar(boolean detalhado) {
        List<ItemRelatorio> lista = filtraritensDetalhados(detalhado);

        double total = 0;
        for (int i = 0; i < lista.size(); i++) {
            total += lista.get(i).getValor();
        }

        exportador.exportar("Relatório Financeiro", lista, total);
    }
}
