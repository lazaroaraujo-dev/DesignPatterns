package model;

import java.util.List;

public class Pedido {

    private final String tipo;
    private final String tamanho;
    private final String pagamento;
    private final List<String> itens;

    private final String tipoPao;
    private final String tipoMassa;
    private final boolean bordaRecheada;

    private final String entrega;
    private final String enderecoEntrega;
    private final String cupom;

    private final String observacoes;
    private final Double trocoPara;

    public Pedido(String tipo, String tamanho, String pagamento,
                  List<String> itens, String tipoPao, String tipoMassa,
                  boolean bordaRecheada, String entrega, String enderecoEntrega,
                  String cupom, String observacoes, Double trocoPara){
        this.tipo = tipo;
        this.tamanho = tamanho;
        this.pagamento = pagamento;
        this.itens = itens;
        this.tipoPao = tipoPao;
        this.tipoMassa = tipoMassa;
        this.bordaRecheada = bordaRecheada;
        this.entrega = entrega;
        this.enderecoEntrega = enderecoEntrega;
        this.cupom = cupom;
        this.observacoes = observacoes;
        this.trocoPara = trocoPara;
    }
    public void printPedido() {

        System.out.println("Tipo: "+ tipo);
        System.out.println("Tamanho: "+ tamanho);
        System.out.println("Pagamento: "+ pagamento);
        System.out.println("Itens: ");
        for (String item : itens) {
            System.out.println("- "+ item);
        }
        if (tipoPao != null) {
            System.out.println("Pão: "+tipoPao);
        }
        if (tipoMassa != null) {
            System.out.println("Massa: "+tipoMassa);
        }
        if (bordaRecheada) {
            System.out.println("Borda Recheada: SIM");
        }

        System.out.println("Entrega: "+entrega);

        if (enderecoEntrega != null) {
            System.out.println("Endereço de entrega: "+ enderecoEntrega);
        }
        if (cupom != null) {
            System.out.println("Cupom: "+cupom);
        }
        if (observacoes != null) {
            System.out.println("Observações: "+observacoes);
        }
        if (trocoPara != null) {
            System.out.println("Troco para: R$ "+trocoPara);
        }

    }
}
