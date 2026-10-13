public abstract class ProcessadorArquivo {

    public final void processarArquivo(){
        abrirArquivo();
        validarEstrutura();
        lerDados();
        processarDados();
        salvarResultado();
        fecharArquivo();
    }
    protected void abrirArquivo(){
        System.out.println("Abrindo arquivo...");
    }

    protected abstract void validarEstrutura();
    protected abstract void lerDados();
    protected abstract void processarDados();

    public void salvarResultado(){
        System.out.println("Salvando resultado...");
    }

    protected void fecharArquivo(){
        System.out.println("Fechando arquivo...");
    }
}
