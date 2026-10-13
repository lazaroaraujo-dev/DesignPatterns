public class FilmePremiumProxy implements Conteudo{

    private final FilmePremium filmePremium;

    public FilmePremiumProxy(){
        this.filmePremium = new FilmePremium();
    }

    @Override
    public void assistir(Usuario usuario) {
        if (usuario != null) {
            if (usuario.getPlano().equalsIgnoreCase("PREMIUM")) {
                System.out.println("Acesso liberado para " + usuario.getNome());
                filmePremium.assistir(usuario);
            } else if (usuario.getPlano().equalsIgnoreCase("BASICO")) {
                System.out.println("Acesso negado para " + usuario.getNome() +
                        " conteúdo disponível apenas para usuários PREMIUM.");
            }
        }  else {
            throw new IllegalArgumentException("Usuário inválido.");
        }
    }
}
