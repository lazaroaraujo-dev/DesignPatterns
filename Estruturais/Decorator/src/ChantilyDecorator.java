public class ChantilyDecorator implements Bebida{
    private final Bebida bebida;

    public ChantilyDecorator(Bebida bebida) {
        this.bebida = bebida;
    }
    @Override
    public String getDescricao() {
        return bebida.getDescricao() + " + ChantilyDecorator";
    }
    public double getPreco() {
        return bebida.getPreco() + 3.00;
    }
}
