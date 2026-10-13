public class ProcessadorVendas extends ProcessadorArquivo{

    @Override
    protected void validarEstrutura(){
        System.out.println("Validando dados da venda.");
    }

    @Override
    protected void lerDados(){
        System.out.println("Lendo dados da vendo.");
    }

    @Override
    protected void processarDados(){
        System.out.println("Processando dados da venda.");
    }
}
