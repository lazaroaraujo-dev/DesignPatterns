class ValidacaoMiddleware extends Middleware {

    @Override
    public boolean processar(Requisicao req) {
        if (!req.dadosValidos) {
            System.out.println("VALIDAÇÃO: Dados inválidos");
            return false;
        }
        return chamarProximo(req);
    }
}