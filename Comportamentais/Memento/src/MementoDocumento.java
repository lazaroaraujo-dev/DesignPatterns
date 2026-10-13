import java.time.LocalDateTime;

public class MementoDocumento {

    private String titulo;
    private String conteudo;
    private String autor;
    private LocalDateTime dataHora;

    public MementoDocumento(String titulo,
                            String conteudo,
                            String autor,
                            LocalDateTime dataHora) {

        this.titulo = titulo;
        this.conteudo = conteudo;
        this.autor = autor;
        this.dataHora = dataHora;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getConteudo() {
        return conteudo;
    }

    public String getAutor() {
        return autor;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }
}