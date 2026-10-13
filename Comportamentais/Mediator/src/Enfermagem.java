public class Enfermagem extends Participante {

    public Enfermagem(MediadorClinica mediador) {
        super(mediador);
    }

    public void prepararPaciente() {

        System.out.println("[ENFERMAGEM]");
        System.out.println("Preparando paciente.");

        mediador.enviarMensagem(
                "Paciente preparado.",
                this
        );
    }

    public void receberMensagem(String mensagem) {

        System.out.println("[ENFERMAGEM]");
        System.out.println(mensagem);

        prepararPaciente();
    }
}