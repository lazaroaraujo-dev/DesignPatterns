public class Frota implements Setor {

    private int quantidadeVeiculos;
    private boolean manutencaoEmDia;

    public Frota(int quantidadeVeiculos, boolean manutencaoEmDia) {
        this.quantidadeVeiculos = quantidadeVeiculos;
        this.manutencaoEmDia = manutencaoEmDia;
    }

    public int getQuantidadeVeiculos() {
        return quantidadeVeiculos;
    }

    public boolean isManutencaoEmDia() {
        return manutencaoEmDia;
    }

    @Override
    public void aceitar(VisitanteSetor visitante) {
        visitante.visitar(this);
    }
}