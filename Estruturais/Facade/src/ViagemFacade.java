public class ViagemFacade {
    public Reserva reservasViagem(Cliente cliente, String destino) {

        VooService voo = new VooService();
        HotelService hotel = new HotelService();
        TransportService transporte = new TransportService();
        ComprovanteService comprovante = new ComprovanteService();
        NotificacaoService confirmacao = new NotificacaoService();

        voo.reservarVoo(destino);
        hotel.reservarHotel(destino);
        transporte.reservarTransporte(destino);
        Reserva reserva = comprovante.gerarComprovante(destino);
        confirmacao.enviarConfirmacao(cliente,reserva);
        return reserva;
    }
}
