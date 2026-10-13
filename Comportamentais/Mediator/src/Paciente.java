public class Paciente extends Participante {

    private String nome;

    public Paciente(String nome,
                    MediadorClinica mediador) {

        super(mediador);
        this.nome = nome;
    }

    public void chegarClinica() {

        System.out.println("[PACIENTE]");
        System.out.println(nome +
                " chegou à clínica.");

        mediador.enviarMensagem(
                "Paciente chegou.",
                this
        );
    }
}