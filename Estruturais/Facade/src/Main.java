public class Main {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("João", "joao@email.com");
        Cliente cliente2 = new Cliente("Maria", "maria@email.com");

        ViagemFacade viagemFacade1 = new ViagemFacade();
        viagemFacade1.reservasViagem(cliente1, "Recife");
        viagemFacade1.reservasViagem(cliente2, "São Paulo");

    }
}