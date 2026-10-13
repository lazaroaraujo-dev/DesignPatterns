import java.util.List;

public class ExportadorExcel implements Exportador{
    @Override
    public void exportar(String titulo, List<ItemRelatorio> itens, double total){
        System.out.println("=== EXPORTANDO EXCEL ===\n"+
                "Titulo: "+ titulo+
                "\nItens: ");
        for (int i = 0; i<itens.size(); i++) {
            System.out.println(" - " + itens.get(i).getDescricao() +
                    " | R$ " + itens.get(i).getValor());
        }
        System.out.println("Total; +"+total+"\n==================\n");
    }
}
