public class EstadoAguardandoCliente implements EstadoChamado{

    @Override
    public void iniciarAtendimento(Chamado chamado){
        System.out.println("Não é possível fazer essa transição (Aguardando cliente -> Em atendimento");
    }
    @Override
    public void aguardarCliente(Chamado chamado){
        System.out.println("Não é possível fazer essa transição (Aguardando cliente -> Aguardando cliente)");
    }

    @Override
    public void responderCliente(Chamado chamado) {
        chamado.setEstado(new EstadoEmAtendimento());
        System.out.println("Aguardando Cliente -> Em atendimento");
    }

    @Override
    public void resolver(Chamado chamado) {
        System.out.println("Não é possível fazer essa transição (Aguardando Cliente -> Resolvido)");
    }

    @Override
    public void cancelar(Chamado chamado) {
        chamado.setEstado(new EstadoCancelado());
        System.out.println("Aguardando Cliente -> Cancelado");
    }
}
