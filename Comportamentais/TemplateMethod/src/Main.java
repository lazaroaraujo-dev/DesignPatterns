public class Main {
    public static void main(String[] args) {
        ProcessadorArquivo cliente1 = new ProcessadorClientes();
        cliente1.processarArquivo();

        ProcessadorArquivo produto1 = new ProcessadorProdutos();
        produto1.processarArquivo();

        ProcessadorArquivo venda1 = new ProcessadorVendas();
        venda1.processarArquivo();
    }
}