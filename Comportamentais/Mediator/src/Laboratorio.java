public class Laboratorio extends Participante {

    public Laboratorio(MediadorClinica mediador) {
        super(mediador);
    }

    public void realizarExame() {

        System.out.println("[LABORATÓRIO]");
        System.out.println("Exame realizado.");

        mediador.enviarMensagem(
                "Resultado do exame pronto.",
                this
        );
    }

    public void receberMensagem(String mensagem) {

        System.out.println("[LABORATÓRIO]");
        System.out.println(mensagem);

        realizarExame();
    }
}