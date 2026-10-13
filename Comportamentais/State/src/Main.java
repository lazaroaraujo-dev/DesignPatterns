public class Main {
    public static void main(String[] args) {
        Chamado chamado = new Chamado("ABC-1", "Chamado realizado por Cliente VIP", "Beltrano");
        chamado.resolver();
        chamado.iniciarAtendimento();
        chamado.aguardarCliente();
        chamado.resolver();
        chamado.responderCliente();
        chamado.resolver();
        chamado.cancelar();
        Chamado chamado2 = new Chamado("ABC-2", "Chamado realizado por cliente Premium", "Sicrano");
        chamado2.cancelar();
        chamado2.iniciarAtendimento();
    }
}