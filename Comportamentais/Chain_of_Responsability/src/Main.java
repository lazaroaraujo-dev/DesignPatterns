public class Main {
    public static void main(String[] args) {

        // Criando middlewares
        Middleware auth = new AuthMiddleware();
        Middleware perm = new PermissaoMiddleware();
        Middleware valid = new ValidacaoMiddleware();
        Middleware log = new LogMiddleware();
        Middleware controller = new ControllerMiddleware();


        auth.setProximo(perm);
        perm.setProximo(valid);
        valid.setProximo(log);
        log.setProximo(controller);


        System.out.println("CENÁRIO 1:");
        Requisicao req1 = new Requisicao("admin", "valido", "ADMIN", true);
        auth.processar(req1);


        System.out.println("\nCENÁRIO 2:");
        Requisicao req2 = new Requisicao("admin", "invalido", "ADMIN", true);
        auth.processar(req2);


        System.out.println("\nCENÁRIO 3:");
        Requisicao req3 = new Requisicao("user", "valido", "USER", true);
        auth.processar(req3);


        System.out.println("\nCENÁRIO 4:");
        Requisicao req4 = new Requisicao("admin", "valido", "ADMIN", false);
        auth.processar(req4);
    }
}