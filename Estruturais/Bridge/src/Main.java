public class Main {
    public static void main(String[] args) {

        ItemRelatorio item1 = new ItemRelatorio("Produto A", 50);
        ItemRelatorio item2 = new ItemRelatorio("Produto B", 200);
        ItemRelatorio item3 = new ItemRelatorio("Produto C", 150);

        Exportador pdf = new ExportadorPDF();
        Relatorio rel1 = new RelatorioFinanceiro(pdf);
        rel1.adicionarItem(item1);
        rel1.adicionarItem(item2);
        rel1.adicionarItem(item3);
        ((RelatorioFinanceiro) rel1).gerar(false);

        Exportador excel = new ExportadorExcel();
        Relatorio rel2 = new RelatorioFinanceiro(excel);
        rel2.adicionarItem(item1);
        rel2.adicionarItem(item2);
        rel2.adicionarItem(item3);
        ((RelatorioFinanceiro) rel2).gerar(true);

        Relatorio rel3 = new RelatorioVendas(pdf);
        rel3.adicionarItem(item1);
        rel3.adicionarItem(item2);
        rel3.adicionarItem(item3);
        ((RelatorioVendas) rel3).gerar(true);

        Relatorio rel4 = new RelatorioVendas(excel);
        rel4.adicionarItem(item1);
        rel4.adicionarItem(item2);
        rel4.adicionarItem(item3);
        ((RelatorioVendas) rel4).gerar(false);
    }
}