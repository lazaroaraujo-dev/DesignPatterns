public class Administrativo implements Setor {

    private int quantidadeFuncionarios;
    private boolean documentosPendentes;

    public Administrativo(int quantidadeFuncionarios, boolean documentosPendentes) {
        this.quantidadeFuncionarios = quantidadeFuncionarios;
        this.documentosPendentes = documentosPendentes;
    }

    public int getQuantidadeFuncionarios() {
        return quantidadeFuncionarios;
    }

    public boolean isDocumentosPendentes() {
        return documentosPendentes;
    }

    @Override
    public void aceitar(VisitanteSetor visitante) {
        visitante.visitar(this);
    }
}