import java.util.ArrayList;
import java.util.List;

public class HistoricoDocumento {

    private List<MementoDocumento> historico =
            new ArrayList<>();

    public void adicionarVersao(MementoDocumento memento) {

        historico.add(memento);
    }

    public MementoDocumento recuperarVersao(int indice) {

        return historico.get(indice);
    }
}