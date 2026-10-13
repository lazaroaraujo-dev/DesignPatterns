public class CentralAtendimentoClinica implements MediadorClinica {

    private Recepcao recepcao;
    private Medico medico;
    private Enfermagem enfermagem;
    private Laboratorio laboratorio;
    private Paciente paciente;

    public void setRecepcao(Recepcao recepcao) {
        this.recepcao = recepcao;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public void setEnfermagem(Enfermagem enfermagem) {
        this.enfermagem = enfermagem;
    }

    public void setLaboratorio(Laboratorio laboratorio) {
        this.laboratorio = laboratorio;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    @Override
    public void enviarMensagem(String mensagem,
                               Participante remetente) {

        System.out.println("\n[CENTRAL]");
        System.out.println("Mensagem recebida: "
                + mensagem);

        if (remetente instanceof Paciente) {

            recepcao.receberMensagem(
                    "Paciente chegou para atendimento."
            );
        }

        else if (remetente instanceof Recepcao) {

            medico.receberMensagem(
                    "Paciente encaminhado ao médico."
            );
        }

        else if (remetente instanceof Medico) {

            laboratorio.receberMensagem(
                    "Realizar exame solicitado."
            );
        }

        else if (remetente instanceof Laboratorio) {

            enfermagem.receberMensagem(
                    "Exame pronto. Preparar paciente."
            );
        }

        else if (remetente instanceof Enfermagem) {

            recepcao.receberMensagem(
                    "Paciente pronto. Finalizar atendimento."
            );
        }
    }
}