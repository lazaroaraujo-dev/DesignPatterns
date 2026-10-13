package builder;

import model.Pedido;

import java.util.ArrayList;
import java.util.List;

public class PedidoBuilder {

    private String tipo;
    private String tamanho;
    private String pagamento;
    private List<String> itens = new ArrayList<>();

    private String tipoPao;
    private String tipoMassa;
    private boolean bordaRecheada;

    private String entrega;
    private String enderecoEntrega;
    private String cupom;

    private String observacoes;
    private Double trocoPara;

    public PedidoBuilder tipoHamburguer(){
        this.tipo = "HAMBURGUER";
        return this;
    }
    public PedidoBuilder tipoPizza() {
        this.tipo = "PIZZA";
        return this;
    }
    public PedidoBuilder tamanhoP() {
        this.tamanho = "P";
        return this;
    }
    public PedidoBuilder tamanhoM() {
        this.tamanho = "M";
        return this;
    }
    public PedidoBuilder tamanhoG() {
        this.tamanho = "G";
        return this;
    }
    public PedidoBuilder pagamentoCartao() {
        this.pagamento = "CARTÃO";
        return this;
    }
    public PedidoBuilder pagamentoDinheiro(){
        this.pagamento = "DINHEIRO";
        return this;
    }
    public PedidoBuilder pagamentoPix(){
        this.pagamento = "PIX";
        return this;
    }
    public PedidoBuilder comTrocoPara(double valor){
        this.trocoPara = valor;
        return this;
    }
    public PedidoBuilder entregaDelivery(String endereco){
        this.entrega = "Delivery";
        this.enderecoEntrega = endereco;
        return this;
    }
    public PedidoBuilder entregaRetirada(){
        this.entrega = "Retirada";
        return this;
    }
    public PedidoBuilder tipoPao(String pao) {
        this.tipoPao = pao;
        return this;
    }
    public PedidoBuilder tipoMassa(String massa){
        this.tipoMassa = massa;
        return this;
    }
    public PedidoBuilder comBordaRecheada() {
        this.bordaRecheada = true;
        return this;
    }
    public PedidoBuilder semBordaRecheada(){
        this.bordaRecheada = false;
        return this;
    }
    public PedidoBuilder addItem(String item){
        this.itens.add(item);
        return this;
    }
    public PedidoBuilder comCupom(String cupom){
        this.cupom = cupom;
        return this;
    }
    public PedidoBuilder comObservacao(String obs){
        this.observacoes = obs;
        return this;
    }
    public Pedido build(){
        if (!"HAMBURGUER".equals(tipo)&&!"PIZZA".equals(tipo)){throw new IllegalStateException("Tipo inexistente");}
        if (!"P".equals(tamanho)&&!"M".equals(tamanho)&&!"G".equals(tamanho)){throw new IllegalStateException("Tamanho inválido");}
        if (!"PIX".equals(pagamento)&&!"CARTÃO".equals(pagamento)&&!"DINHEIRO".equals(pagamento)){throw new IllegalStateException("Escolha de pagamento inválida");}
        if (itens==null || itens.isEmpty()){throw new IllegalStateException("Não apresentou nenhum item.");}
        if ("HAMBURGUER".equals(tipo)){
            if (tipoPao == null || tipoPao.isBlank()){
                throw new IllegalStateException("O Hambúrguer deve ter 1 tipo de pão.");
            }
            if (!"BRIOCHE".equalsIgnoreCase(tipoPao) &&
                    !"TRADICIONAL".equalsIgnoreCase(tipoPao) &&
                    !"INTEGRAL".equalsIgnoreCase(tipoPao)) {
                throw new IllegalStateException("Tipo de pão inválido.");
            }
            if (!(tipoMassa == null)||(bordaRecheada)){
                throw new IllegalStateException("Massa e borda recheada são somente para pizzas.");
            }
        }
        if ("PIZZA".equals(tipo)){
            if (tipoMassa == null || tipoMassa.isBlank()){
                throw new IllegalStateException("É necessário 1 tipo de massa.");
            }
            if (!"FINA".equalsIgnoreCase(tipoMassa) &&
                    !"TRADICIONAL".equalsIgnoreCase(tipoMassa) &&
                    !"PAN".equalsIgnoreCase(tipoMassa)) {
                throw new IllegalStateException("Tipo de massa inválido.");
            }
            if (!(tipoPao == null)) {
                throw new IllegalStateException("Tipo de pão é somente para hambúrguer.");
            }
        }
        if (!("DELIVERY".equalsIgnoreCase(entrega)) && !("RETIRADA".equalsIgnoreCase(entrega))){
            throw new IllegalStateException("Tipo de entrega inválida.");
        }
        if ("DELIVERY".equalsIgnoreCase(entrega)){
            if (enderecoEntrega == null || enderecoEntrega.isBlank()){
                throw new IllegalStateException("Delivery exige endereço de entrega");
            }
        }
        if ("RETIRADA".equalsIgnoreCase(entrega)) {
            enderecoEntrega = null;
        }
        if (!"DINHEIRO".equals(pagamento)) {
            if (trocoPara != null) {
                throw new IllegalStateException("Troco só pode ser informado para pagamento em dinheiro.");
            }
        }
        if ("DINHEIRO".equals(pagamento) && trocoPara != null && trocoPara <= 0) {
            throw new IllegalStateException("Troco deve ser maior que zero.");
        }

        return new Pedido(
                tipo,
                tamanho,
                pagamento,
                itens,
                tipoPao,
                tipoMassa,
                bordaRecheada,
                entrega,
                enderecoEntrega,
                cupom,
                observacoes,
                trocoPara
        );


    }

}
