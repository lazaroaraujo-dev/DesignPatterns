public class FaturamentoService implements PedidoObserver {
    @Override
    public void atualizar(Pedido pedido) {
        if (pedido.getStatus().equals("PAGO")) {
            System.out.println("FATURAMENTO: Gerando lançamento financeiro do pedido " + pedido.getId());
        } else if (pedido.getStatus().equals("CANCELADO")) {
            System.out.println("FATURAMENTO: Estornando valores do pedido " + pedido.getId());
        }
    }
}