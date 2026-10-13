public class LogService implements PedidoObserver {
    @Override
    public void atualizar(Pedido pedido) {
        System.out.println("LOG: Pedido " + pedido.getId() +
                " alterado para " + pedido.getStatus());
    }
}