import java.beans.BeanDescriptor;

public class Main {
    public static void main(String[] args) {
        Bebida cafe = new Cafe();
        Bebida cafecomLeite = new LeiteExtraDecorator(cafe);

        System.out.println(cafecomLeite.getDescricao()+"\nPreço: R$ "+cafecomLeite.getPreco());

        System.out.println();

        Bebida capuccino = new Capuccino();
        Bebida capuccinoCanela = new CanelaDecorator(capuccino);
        Bebida capuccinoComChantilly = new ChantilyDecorator(capuccinoCanela);

        System.out.println(capuccinoComChantilly.getDescricao()+"\nPreço: R$ "+capuccinoComChantilly.getPreco());

        System.out.println();

        Bebida chocolateQuente = new ChocolateQuente();
        Bebida chocolateQuenteLeite = new LeiteExtraDecorator(chocolateQuente);
        Bebida chocolateQuenteChantilly = new ChantilyDecorator(chocolateQuenteLeite);
        Bebida chocolateQuenteCalda = new CaldaChocolateDecorator(chocolateQuenteChantilly);

        System.out.println(chocolateQuenteCalda.getDescricao()+"\nPreço: R$ "+chocolateQuenteCalda.getPreco());




    }
}