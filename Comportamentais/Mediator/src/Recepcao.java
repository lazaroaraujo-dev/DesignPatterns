public class Recepcao extends Participante {

    public Recepcao(MediadorClinica mediador) {
        super(mediador);
    }

    public void iniciarAtendimento() {

        System.out.println("[RECEPÇÃO]");
        System.out.println("Iniciando atendimento.");

        mediador.enviarMensagem(
                "Atendimento iniciado.",
                this
        );
    }

    public void receberMensagem(String mensagem) {

        System.out.println("[RECEPÇÃO]");
        System.out.println(mensagem);
    }
}