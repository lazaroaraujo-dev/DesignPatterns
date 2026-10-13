public class EstadoAberto implements EstadoChamado {
    @Override
    public void iniciarAtendimento(Chamado chamado){
        chamado.setEstado(new EstadoEmAtendimento());
        System.out.println("Em aberto -> Em atendimento ");
    }

    @Override
    public void aguardarCliente(Chamado chamado) {
        System.out.println("Não é possível fazer essa transição (Aberto -> Aguardar Cliente)");
    }

    @Override
    public void responderCliente(Chamado chamado) {
        System.out.println("Não é possível fazer essa transição (Aberto -> Responder Cliente)");
    }

    @Override
    public void resolver(Chamado chamado) {
        System.out.println("Não é possível fazer essa transição (Aberto -> Resolver)");
    }

    @Override
    public void cancelar(Chamado chamado) {
        chamado.setEstado(new EstadoCancelado());
        System.out.println("Em aberto -> Cancelado ");
    }
}
