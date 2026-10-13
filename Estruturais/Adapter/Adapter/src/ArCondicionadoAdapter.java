public class ArCondicionadoAdapter implements ControleUniversal{
    private final ArCondicionadoApi arCondicionado;

    public ArCondicionadoAdapter(ArCondicionadoApi arCondicionado){
        this.arCondicionado = arCondicionado;
    }

    @Override
    public void ligar() {arCondicionado.ligarArCondicionado();}

    @Override
    public void desligar() {arCondicionado.desligarArCondicionado();}

    @Override
    public void aumentarVolume() {arCondicionado.aumentarTemp();}

    @Override
    public void diminuirVolume() {arCondicionado.diminuirTemp();}
}
