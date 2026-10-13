import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FilaAtendimento filaAtendimento = new FilaAtendimento();

        filaAtendimento.adicionarNaFila(new SenhaAtendimento("Pessoa 1", "A001", "Prioritário"));
        filaAtendimento.adicionarNaFila(new SenhaAtendimento("Pessoa 2", "A002", "Normal"));
        filaAtendimento.adicionarNaFila(new SenhaAtendimento("Pessoa 3", "A003", "Financiamento"));
        filaAtendimento.adicionarNaFila(new SenhaAtendimento("Pessoa 4", "A004", "Agendamento"));
        filaAtendimento.adicionarNaFila(new SenhaAtendimento("Pessoa 5", "A005", "Suporte"));

        IteratorSenha iteratorSenha = filaAtendimento.criarIterator();
        Scanner scanner = new Scanner(System.in);
        while(iteratorSenha.temProximo()){
            System.out.println("Pressione ENTER para mostrar a próxima pessoa da fila.");
            scanner.nextLine();

            SenhaAtendimento senha = iteratorSenha.proxima();
            System.out.println(senha.toString());
        }
        scanner.close();

    }
}