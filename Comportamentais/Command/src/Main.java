public class Main {
    public static void main(String[] args) {

        GerenciadorTarefas g = new GerenciadorTarefas();
        PainelControle p = new PainelControle();


        p.executarComando(new AdicionarTarefaCommand(g, "Estudar Command"));
        p.executarComando(new AdicionarTarefaCommand(g, "Implementar exercício"));
        p.executarComando(new ConcluirTarefaCommand(g, "Estudar Command"));

        p.desfazerUltimoComando();


        p.adicionarNaFila(new AdicionarTarefaCommand(g, "Revisar Big O"));
        p.adicionarNaFila(new AdicionarTarefaCommand(g, "Estudar Chain of Responsibility"));
        p.adicionarNaFila(new ConcluirTarefaCommand(g, "Implementar exercício"));

        p.processarFila();


        g.listarTarefas();
    }
}