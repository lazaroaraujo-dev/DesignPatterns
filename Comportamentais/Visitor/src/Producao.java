public class Producao implements Setor {

    private int nivelRisco;
    private boolean usoEpi;

    public Producao(int nivelRisco, boolean usoEpi) {
        this.nivelRisco = nivelRisco;
        this.usoEpi = usoEpi;
    }

    public int getNivelRisco() {
        return nivelRisco;
    }

    public boolean isUsoEpi() {
        return usoEpi;
    }

    @Override
    public void aceitar(VisitanteSetor visitante) {
        visitante.visitar(this);
    }
}