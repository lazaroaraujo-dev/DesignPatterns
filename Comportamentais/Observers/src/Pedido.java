import java.util.ArrayList;
import java.util.List;

public class Pedido implements PedidoSubject {
    private String id;
    private String status;
    private Cliente cliente;
    private List<PedidoObserver> observers;

    public Pedido(String id, String status, Cliente cliente) {
        this.id = id;
        this.status = status;
        this.cliente = cliente;
        this.observers = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public Cliente getCliente() {
        return cliente;
    }

    @Override
    public void adicionarObserver(PedidoObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removerObserver(PedidoObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notificarObservers() {
        for (PedidoObserver o : observers) {
            o.atualizar(this);
        }
    }

    public void atualizarStatus(String novoStatus) {
        if (novoStatus == null || novoStatus.isEmpty()) {
            throw new IllegalArgumentException("Status inválido");
        }

        this.status = novoStatus;
        notificarObservers();
    }
}