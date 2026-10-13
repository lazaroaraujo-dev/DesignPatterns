public class NotificacaoService {
    public void enviarConfirmacao(Cliente cliente, Reserva reserva){
        System.out.println("Confirmação enviada para "+cliente.getEmail()+" com código "+reserva.getCodigo());
    }
}
