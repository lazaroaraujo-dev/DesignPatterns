public class Reserva {
    private final String destino;
    private final String codigo;

    public Reserva(String destino, String codigo){
        this.destino = destino;
        this.codigo = codigo;
    }
    public String getDestino(){
        return destino;
    }
    public String getCodigo(){
        return codigo;
    }
}
