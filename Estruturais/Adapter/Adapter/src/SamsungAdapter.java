
public class SamsungAdapter implements ControleUniversal {
    private final TvSamungApi tv;

    public SamsungAdapter(TvSamungApi tv){
        this.tv = tv;
    }

    @Override
    public void ligar() {tv.powerOn();}
    @Override
    public void desligar() {tv.powerOff();}
    @Override
    public void aumentarVolume() {tv.volumeUp();}
    @Override
    public void diminuirVolume() {tv.volumeDown();}
}
