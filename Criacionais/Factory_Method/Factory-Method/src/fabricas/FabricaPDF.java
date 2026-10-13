package fabricas;
import documentos.Documento;
import documentos.PDF;
public class FabricaPDF extends FabricaDocumento {
    @Override
    public Documento criarDocumento(){
        return new PDF();
    }
}
