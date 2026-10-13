import java.util.ArrayList;
import java.util.List;

public class Prova {
    private String titulo;
    private String turma;
    private String data;
    private String versao;
    private List<Questao> questoes;

    public Prova(String titulo, String turma, String data, String versao, List<Questao> questoes) {
        this.titulo = titulo;
        this.turma = turma;
        this.data = data;
        this.versao = versao;
        this.questoes = questoes;
    }

    public Prova copiar() {
        List<Questao> novasQuestoes = new ArrayList<>();

        for (Questao q : this.questoes) {
            novasQuestoes.add(q.copiar());
        }

        return new Prova(this.titulo, this.turma, this.data, this.versao, novasQuestoes);
    }

    public int totalPontos() {
        int total = 0;
        for (Questao q : questoes) {
            total += q.getPontos();
        }
        return total;
    }

    public void substituirQuestao(String id, Questao nova) {
        for (int i = 0; i < questoes.size(); i++) {
            if (questoes.get(i).getId().equals(id)) {
                questoes.set(i, nova);
                return;
            }
        }
    }

    public void printResumo() {
        System.out.println("Título: " + titulo);
        System.out.println("Turma: " + turma);
        System.out.println("Data: " + data);
        System.out.println("Versão: " + versao);
        System.out.println("Total de pontos: " + totalPontos());
        System.out.println("Questões:");

        for (Questao q : questoes) {
            System.out.println("- " + q.getId() + " (" + q.getPontos() + " pontos)");
        }

        System.out.println();
    }

    public String getTitulo() {
        return titulo;
    }

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getVersao() {
        return versao;
    }

    public void setVersao(String versao) {
        this.versao = versao;
    }

    public List<Questao> getQuestoes() {
        return questoes;
    }
}