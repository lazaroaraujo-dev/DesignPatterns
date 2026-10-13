public class ProcessadorClientes extends ProcessadorArquivo{

    @Override
    protected void validarEstrutura(){
        System.out.println("Validando informações do cliente.");
    }

    @Override
    protected void lerDados(){
        System.out.println("Lendo dados do cliente.");
    }

    @Override
    protected void processarDados(){
        System.out.println("Processando dados do cliente.");
    }
}
