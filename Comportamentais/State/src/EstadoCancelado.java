public class EstadoCancelado implements EstadoChamado {

    @Override
    public void iniciarAtendimento(Chamado chamado) {
        System.out.println(
                "Não é possível atender um chamado cancelado."
        );
    }

    @Override
    public void aguardarCliente(Chamado chamado) {
        System.out.println(
                "Não é possível alterar um chamado cancelado."
        );
    }

    @Override
    public void responderCliente(Chamado chamado) {
        System.out.println(
                "Não é possível alterar um chamado cancelado."
        );
    }

    @Override
    public void resolver(Chamado chamado) {
        System.out.println(
                "Não é possível resolver um chamado cancelado."
        );
    }

    @Override
    public void cancelar(Chamado chamado) {
        System.out.println(
                "O chamado já está cancelado."
        );
    }
}