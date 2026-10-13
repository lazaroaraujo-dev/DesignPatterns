public class ProcessadorProdutos extends ProcessadorArquivo{

    @Override
    protected void validarEstrutura(){
        System.out.println("Validando dados do produto.");
    }

    @Override
    protected void lerDados(){
        System.out.println("Lendo dados do produto.");
    }

    @Override
    protected void processarDados(){
        System.out.println("Processando dados do produto.");
    }
}
