public class Main {
    public static void main(String[] args) {

        Cliente cliente = new Cliente("Lázaro", "email@email.com");

        Pedido pedido = new Pedido("PED-001", "CRIADO", cliente);

        pedido.adicionarObserver(new EmailService());
        pedido.adicionarObserver(new LogService());
        pedido.adicionarObserver(new DashboardService());
        pedido.adicionarObserver(new EstoqueService());
        pedido.adicionarObserver(new FaturamentoService());


        System.out.println("\n--- PAGO ---");
        pedido.atualizarStatus("PAGO");

        System.out.println("\n--- EM_SEPARACAO ---");
        pedido.atualizarStatus("EM_SEPARACAO");

        System.out.println("\n--- ENVIADO ---");
        pedido.atualizarStatus("ENVIADO");

        System.out.println("\n--- CANCELADO ---");
        pedido.atualizarStatus("CANCELADO");
    }
}