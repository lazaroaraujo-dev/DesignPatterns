public class MiRemoteApp {
    private final ControleUniversal dispositivo;

    public MiRemoteApp(ControleUniversal dispositivo){
        this.dispositivo = dispositivo;
    }

    public void iniciar() {
        dispositivo.ligar();
        dispositivo.aumentarVolume();
        System.out.println("[Mi Remote] Assistindo...");
    }
    public void encerrar() {
        dispositivo.diminuirVolume();
        dispositivo.desligar();
        System.out.println("[Mi Remote] Encerrado.");
    }
}
