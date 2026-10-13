public class Main {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("Cliente 1", "cliente1@exemplo.com");
        Cliente cliente2 = new Cliente("Cliente 2", "cliente2@exemplo.com");

        ViagemFacade viagemFacade1 = new ViagemFacade();
        viagemFacade1.reservasViagem(cliente1, "Recife");
        viagemFacade1.reservasViagem(cliente2, "São Paulo");

    }
}