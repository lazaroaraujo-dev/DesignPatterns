public interface EstadoChamado {
    void iniciarAtendimento(Chamado chamado);
    void aguardarCliente(Chamado chamado);
    void responderCliente(Chamado chamado);
    void resolver(Chamado chamado);
    void cancelar(Chamado chamado);
}
