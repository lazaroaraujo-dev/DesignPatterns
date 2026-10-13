public class LeiteExtraDecorator implements Bebida{

    private final Bebida bebida;

    public LeiteExtraDecorator(Bebida bebida) {
        this.bebida = bebida;
    }
    @Override
    public String getDescricao() {
        return bebida.getDescricao() + " + Leite Extra";
    }
    @Override
    public double getPreco() {
        return bebida.getPreco() + 2.00;
    }
}
