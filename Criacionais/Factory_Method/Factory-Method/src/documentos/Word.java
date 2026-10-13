package documentos;

public class Word implements Documento {
    @Override
    public void gerar(){
        System.out.println("Gerando documento Word...");
    }
}
