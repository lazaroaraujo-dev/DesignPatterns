package factory;

import produto.Frete;
import produto.NotaFiscal;
import produto.Pagamento;
import produto.nacional.FreteNacional;
import produto.nacional.NotaFiscalNacional;
import produto.nacional.PagamentoNacional;

public class FornecedorNacionalFactory implements FornecedorFactory{
    @Override
    public Pagamento criarPagamento() {
        return new PagamentoNacional();
    }

    @Override
    public Frete criarFrete() {
        return new FreteNacional();
    }

    @Override
    public NotaFiscal criarNotaFiscal() {
        return new NotaFiscalNacional();
    }
}
