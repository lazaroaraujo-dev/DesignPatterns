public class AdicionarTarefaCommand implements Command {
    private GerenciadorTarefas gerenciador;
    private String descricao;

    public AdicionarTarefaCommand(GerenciadorTarefas g, String d) {
        this.gerenciador = g;
        this.descricao = d;
    }

    public void execute() {
        gerenciador.adicionarTarefa(descricao);
    }

    public void undo() {
        gerenciador.removerUltimaTarefa();
    }
}