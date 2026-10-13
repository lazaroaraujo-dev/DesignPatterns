import java.util.Stack;
import java.util.LinkedList;
import java.util.Queue;

public class PainelControle {
    private Stack<Command> historico = new Stack<>();
    private Queue<Command> fila = new LinkedList<>();

    public void executarComando(Command command) {
        command.execute();
        historico.push(command);
    }

    public void desfazerUltimoComando() {
        if (!historico.isEmpty()) {
            System.out.println("\nDesfazendo último comando...");
            Command c = historico.pop();
            c.undo();
        }
    }

    public void adicionarNaFila(Command command) {
        fila.add(command);
        System.out.println("Comando adicionado na fila.");
    }

    public void processarFila() {
        System.out.println("\nProcessando fila...");
        while (!fila.isEmpty()) {
            Command c = fila.poll();
            c.execute();
            historico.push(c);
        }
    }
}