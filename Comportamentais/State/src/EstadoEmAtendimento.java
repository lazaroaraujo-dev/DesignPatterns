public class EstadoEmAtendimento implements EstadoChamado{
    @Override
    public void iniciarAtendimento(Chamado chamado){
        System.out.println("Não é possível fazer essa transição (Em atendimento -> Em atendimento");
    }
    @Override
    public void aguardarCliente(Chamado chamado){
        chamado.setEstado(new EstadoAguardandoCliente());
        System.out.println("Em atendimento -> Aguardando Cliente");
    }

    @Override
    public void responderCliente(Chamado chamado) {
        System.out.println("Não é possível fazer essa transição (Em atendimento -> Responder Cliente)");
    }

    @Override
    public void resolver(Chamado chamado) {
        chamado.setEstado(new EstadoResolvido());
        System.out.println("Em atendimento -> Resolvido");
    }

    @Override
    public void cancelar(Chamado chamado) {
        chamado.setEstado(new EstadoCancelado());
        System.out.println("Em atendimento -> Cancelado");
    }
}
