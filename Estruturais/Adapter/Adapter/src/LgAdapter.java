public class LgAdapter implements ControleUniversal{
    private final TvLgApi tv;

    public LgAdapter(TvLgApi tv){
        this.tv = tv;
    }

    @Override
    public void ligar() {tv.ligarTv();}

    @Override
    public void desligar() {tv.desligarTv();}

    @Override
    public void aumentarVolume() {tv.aumentarSom();}

    @Override
    public void diminuirVolume() {tv.reduzirSom();}
}
