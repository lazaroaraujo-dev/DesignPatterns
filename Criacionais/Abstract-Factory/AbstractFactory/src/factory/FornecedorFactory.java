package factory;

import produto.Frete;
import produto.NotaFiscal;
import produto.Pagamento;

public interface FornecedorFactory {
    Pagamento criarPagamento();
    Frete criarFrete();
    NotaFiscal criarNotaFiscal();
}
