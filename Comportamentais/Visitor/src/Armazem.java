public class Armazem implements Setor {

    private int quantidadeEquipamentos;
    private boolean organizado;

    public Armazem(int quantidadeEquipamentos, boolean organizado) {
        this.quantidadeEquipamentos = quantidadeEquipamentos;
        this.organizado = organizado;
    }

    public int getQuantidadeEquipamentos() {
        return quantidadeEquipamentos;
    }

    public boolean isOrganizado() {
        return organizado;
    }

    @Override
    public void aceitar(VisitanteSetor visitante) {
        visitante.visitar(this);
    }
}