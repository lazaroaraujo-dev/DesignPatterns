package documentos;

public class Planilha implements Documento {
    @Override
    public void gerar(){
        System.out.println("Gerando documento Planilha...");
    }
}
