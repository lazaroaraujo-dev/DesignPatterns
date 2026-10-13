import java.util.ArrayList;
import java.util.List;

public class GerenciadorTarefas {
    private List<String> tarefas = new ArrayList<>();

    public void adicionarTarefa(String descricao) {
        tarefas.add(descricao);
        System.out.println("Tarefa adicionada: " + descricao);
    }

    public String removerUltimaTarefa() {
        if (tarefas.isEmpty()) return null;

        String removida = tarefas.remove(tarefas.size() - 1);
        System.out.println("Tarefa removida: " + removida);
        return removida;
    }

    public void restaurarTarefa(String tarefa) {
        tarefas.add(tarefa);
        System.out.println("Tarefa restaurada: " + tarefa);
    }

    public void concluirTarefa(String descricao) {
        for (int i = 0; i < tarefas.size(); i++) {
            if (tarefas.get(i).equals(descricao)) {
                tarefas.set(i, descricao + " [Concluída]");
                System.out.println("Tarefa concluída: " + descricao);
                return;
            }
        }
    }

    public void desfazerConclusao(String descricao) {
        String concluida = descricao + " [Concluída]";
        for (int i = 0; i < tarefas.size(); i++) {
            if (tarefas.get(i).equals(concluida)) {
                tarefas.set(i, descricao);
                System.out.println("Tarefa voltou para pendente: " + descricao);
                return;
            }
        }
    }

    public void listarTarefas() {
        System.out.println("\nLista de tarefas:");
        for (String t : tarefas) {
            System.out.println("- " + t);
        }
    }
}