package factory;

import produto.Frete;
import produto.NotaFiscal;
import produto.Pagamento;
import produto.internacional.FreteInternacional;
import produto.internacional.NotaFiscalInternacional;
import produto.internacional.PagamentoInternacional;

public class FornecedorInternacionalFactory implements FornecedorFactory {
    @Override
    public Pagamento criarPagamento() {
        return new PagamentoInternacional();
    }

    @Override
    public Frete criarFrete() {
        return new FreteInternacional();
    }

    @Override
    public NotaFiscal criarNotaFiscal() {
        return new NotaFiscalInternacional();
    }
}
