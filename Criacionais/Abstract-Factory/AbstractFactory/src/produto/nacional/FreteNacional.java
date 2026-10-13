package produto.nacional;
import produto.Frete;

public class FreteNacional implements Frete {
    @Override
    public double calcularFrete(double pesoKg, String cepDestino){
        return 15.0 + (pesoKg*2.0);
    }
}
