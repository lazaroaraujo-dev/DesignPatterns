public class Main {
    public static void main(String[] args) {

        Conteudo conteudo = new FilmePremiumProxy();

        Usuario usuario1 = new Usuario("Carlos", "PREMIUM");
        Usuario usuario2 = new Usuario("Ana", "BASICO");
        Usuario usuario3 = new Usuario("Marina", "PREMIUM");
        Usuario usuario4 = new Usuario("Pedro", "BASICO");

        conteudo.assistir(usuario1);
        System.out.println();

        conteudo.assistir(usuario2);
        System.out.println();

        conteudo.assistir(usuario3);
        System.out.println();

        conteudo.assistir(usuario4);
        System.out.println();

        try {
            conteudo.assistir(null);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro esperado: " + e.getMessage());
        }
    }
}