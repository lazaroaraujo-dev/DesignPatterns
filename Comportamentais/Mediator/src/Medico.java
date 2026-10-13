public class Medico extends Participante {

    public Medico(MediadorClinica mediador) {
        super(mediador);
    }

    public void solicitarExame() {

        System.out.println("[MÉDICO]");
        System.out.println("Solicitando exame.");

        mediador.enviarMensagem(
                "Solicitação de exame.",
                this
        );
    }

    public void receberMensagem(String mensagem) {

        System.out.println("[MÉDICO]");
        System.out.println(mensagem);

        solicitarExame();
    }
}