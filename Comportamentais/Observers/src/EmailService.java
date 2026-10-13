public class EmailService implements PedidoObserver {
    @Override
    public void atualizar(Pedido pedido) {
        System.out.println("EMAIL: Cliente " + pedido.getCliente().getNome() +
                " avisado sobre status " + pedido.getStatus());
    }
}