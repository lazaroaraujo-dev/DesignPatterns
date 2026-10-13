public class RemoverUltimaTarefaCommand implements Command {
    private GerenciadorTarefas gerenciador;
    private String tarefaRemovida;

    public RemoverUltimaTarefaCommand(GerenciadorTarefas g) {
        this.gerenciador = g;
    }

    public void execute() {
        tarefaRemovida = gerenciador.removerUltimaTarefa();
    }

    public void undo() {
        if (tarefaRemovida != null) {
            gerenciador.restaurarTarefa(tarefaRemovida);
        }
    }
}