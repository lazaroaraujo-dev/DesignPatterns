public class Main {

    public static void main(String[] args) {

        CentralAtendimentoClinica central =
                new CentralAtendimentoClinica();

        Recepcao recepcao =
                new Recepcao(central);

        Medico medico =
                new Medico(central);

        Enfermagem enfermagem =
                new Enfermagem(central);

        Laboratorio laboratorio =
                new Laboratorio(central);

        Paciente paciente =
                new Paciente("Fulano", central);

        central.setRecepcao(recepcao);
        central.setMedico(medico);
        central.setEnfermagem(enfermagem);
        central.setLaboratorio(laboratorio);
        central.setPaciente(paciente);

        // fluxo da clínica
        paciente.chegarClinica();

        recepcao.iniciarAtendimento();
    }
}