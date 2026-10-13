package fabricas;
import documentos.Documento;
import documentos.Planilha;
public class FabricaPlanilha extends FabricaDocumento {
    @Override
    public Documento criarDocumento(){
        return new Planilha();
    }
}
