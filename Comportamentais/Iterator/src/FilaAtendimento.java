import java.util.ArrayList;
import java.util.List;

public class FilaAtendimento {
    private List<SenhaAtendimento> senhas_fila = new ArrayList<>();

    public void adicionarNaFila(SenhaAtendimento senhaAtendimento){
        senhas_fila.add(senhaAtendimento);
    }
    public IteratorSenha criarIterator() {
        return new FilaAtendimentoIterator(senhas_fila);
    }
}
