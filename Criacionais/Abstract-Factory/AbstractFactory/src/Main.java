import factory.FornecedorFactory;
import factory.FornecedorNacionalFactory;
import factory.FornecedorInternacionalFactory;
import service.CheckoutService;

public class Main {

    public static void main(String[] args) {

        FornecedorFactory factoryNacional = new FornecedorNacionalFactory();
        CheckoutService checkoutNacional = new CheckoutService(factoryNacional);

        checkoutNacional.finalizarCompra(
                "PED-10",
                90.0,
                3.0,
                "00000-000"
        );

    System.out.println();
        System.out.println("-----------------------------");

        FornecedorFactory factoryInternacional = new FornecedorInternacionalFactory();

        CheckoutService checkoutInternacional = new CheckoutService(factoryInternacional);

        checkoutInternacional.finalizarCompra(
                "PED-10",
                90.0,
                3.0,
                "00000-000"
        );

    }
}