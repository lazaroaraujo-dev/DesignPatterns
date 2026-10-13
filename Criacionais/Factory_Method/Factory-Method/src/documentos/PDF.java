package documentos;

public class PDF implements Documento {
    @Override
    public void gerar(){
        System.out.println("Gerando documento PDF...");
    }
}
