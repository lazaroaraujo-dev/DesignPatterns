public class ComprovanteService {

    public Reserva gerarComprovante(String destino){
        Reserva reserva = new Reserva(destino,"RES 123");

        System.out.println("Comprovante gerado.");

        return reserva;
    }
}
