public class SenhaAtendimento {

    private String nome;
    private String codigo_senha;
    private String tipo_atendimento;

    public SenhaAtendimento(String nome, String codigo_senha, String tipo_atendimento){
        this.nome = nome;
        this.codigo_senha = codigo_senha;
        this.tipo_atendimento = tipo_atendimento;
    }

    public String getNome(){
        return nome;
    }
    public String getCodigoSenha(){
        return codigo_senha;
    }

    @Override
    public String toString() {
        return nome + " - " + codigo_senha;
    }
}
