abstract class Middleware {
    protected Middleware proximo;

    public void setProximo(Middleware proximo) {
        this.proximo = proximo;
    }

    public abstract boolean processar(Requisicao req);

    protected boolean chamarProximo(Requisicao req) {
        if (proximo == null) return true;
        return proximo.processar(req);
    }
}