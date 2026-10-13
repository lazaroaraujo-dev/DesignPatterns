package Flyweight;

public class Main {
    public static void main(String[] args) {
        TipoBloco pedra1 = BlocoFactory.getBloco("Pedra","pedra.png", true);
        TipoBloco pedra2 = BlocoFactory.getBloco("Pedra", "pedra.png", true);
        TipoBloco pedra3 = BlocoFactory.getBloco("Pedra", "pedra.png", true);

        TipoBloco grama1 = BlocoFactory.getBloco("Grama", "grama.png",true);
        TipoBloco grama2 = BlocoFactory.getBloco("Grama", "grama.png",true);

        TipoBloco madeira = BlocoFactory.getBloco("Madeira", "madeira.png", true);

        pedra1.exibir(10,64,20);
        pedra2.exibir(11,64,20);
        pedra3.exibir(12,64,20);

        grama1.exibir(15,64,22);
        grama2.exibir(16,64,22);

        madeira.exibir(30,65,10);
        System.out.println("pedra1 e pedra2 são o mesmo objeto? "+(pedra1==pedra2));
    }
}