public class ConcluirTarefaCommand implements Command {
    private GerenciadorTarefas gerenciador;
    private String descricao;

    public ConcluirTarefaCommand(GerenciadorTarefas g, String d) {
        this.gerenciador = g;
        this.descricao = d;
    }

    public void execute() {
        gerenciador.concluirTarefa(descricao);
    }

    public void undo() {
        gerenciador.desfazerConclusao(descricao);
    }
}