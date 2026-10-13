package fabricas;
import documentos.Documento;
import documentos.Word;
public class FabricaWord extends FabricaDocumento {
    @Override
    public Documento criarDocumento(){
        return new Word();
    }
}
