import builder.PedidoBuilder;
import model.Pedido;

public class Main {
    public static void main(String[] args) {
        Pedido pedido1 = new PedidoBuilder()
                .tipoHamburguer()
                .tamanhoM()
                .tipoPao("BRIOCHE")
                .addItem("X-Bacon")
                .pagamentoPix()
                .entregaDelivery("Rua Exemplo, 123")
                .comObservacao("Sem cebola")
                .build();

        pedido1.printPedido();
        Pedido pedido2 = new PedidoBuilder()
                .tipoPizza()
                .tamanhoG()
                .tipoMassa("FINA")
                .addItem("Pizza Calabresa")
                .comBordaRecheada()
                .pagamentoCartao()
                .entregaRetirada()
                .comCupom("10OFF")
                .build();

        pedido2.printPedido();
        Pedido pedido3 = new PedidoBuilder()
                .tipoHamburguer()
                .tamanhoP()
                .tipoPao("TRADICIONAL")
                .addItem("X-Salada")
                .pagamentoDinheiro()
                .comTrocoPara(100)
                .entregaRetirada()
                .build();

        pedido3.printPedido();
        try {

            Pedido pedido4 = new PedidoBuilder()
                    .tipoPizza()
                    .tamanhoM()
                    .tipoMassa("FINA")
                    .addItem("Pizza Calabresa")
                    .pagamentoPix()
                    .comTrocoPara(50)
                    .entregaRetirada()
                    .build();

            pedido4.printPedido();

        } catch (IllegalStateException e) {

            System.out.println("Erro esperado: " + e.getMessage());

        }
    }
}