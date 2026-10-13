public class Requisicao {
    String usuario;
    String token;
    String permissao;
    boolean dadosValidos;

    public Requisicao(String usuario, String token, String permissao, boolean dadosValidos) {
        this.usuario = usuario;
        this.token = token;
        this.permissao = permissao;
        this.dadosValidos = dadosValidos;
    }
}
