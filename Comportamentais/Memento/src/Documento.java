import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Documento {

    private String titulo;
    private String conteudo;
    private String autor;
    private LocalDateTime dataUltimaAlteracao;

    public Documento(String titulo, String conteudo, String autor) {

        this.titulo = titulo;
        this.conteudo = conteudo;
        this.autor = autor;
        this.dataUltimaAlteracao = LocalDateTime.now();
    }

    // altera conteúdo
    public void editarConteudo(String novoConteudo) {

        this.conteudo = novoConteudo;
        this.dataUltimaAlteracao = LocalDateTime.now();
    }

    // cria estado salvo
    public MementoDocumento salvar() {

        return new MementoDocumento(
                titulo,
                conteudo,
                autor,
                dataUltimaAlteracao
        );
    }

    // restaura estado
    public void restaurar(MementoDocumento memento) {

        this.titulo = memento.getTitulo();
        this.conteudo = memento.getConteudo();
        this.autor = memento.getAutor();
        this.dataUltimaAlteracao = memento.getDataHora();
    }

    @Override
    public String toString() {

        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        return "Título: " + titulo +
                "\nAutor: " + autor +
                "\nConteúdo: " + conteudo +
                "\nData de modificação: " +
                dataUltimaAlteracao.format(formatter) +
                "\n--------------------------------";
    }
}