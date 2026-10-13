package produto.nacional;

import produto.NotaFiscal;

public class NotaFiscalNacional implements NotaFiscal {
    @Override
    public String emitir(String pedidoId, double valor){
       return ("NF - NAC - "+pedidoId);
    }
}
