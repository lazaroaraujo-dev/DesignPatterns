public class Main {

    public static void main(String[] args) {

        HistoricoDocumento historico =
                new HistoricoDocumento();

        Documento documento = new Documento(
                "Atividade Memento",
                "Texto inicial do documento.",
                "Lázaro"
        );

        System.out.println("ESTADO INICIAL");
        System.out.println(documento);


        historico.adicionarVersao(documento.salvar());

        documento.editarConteudo(
                "Primeira alteração do documento."
        );

        historico.adicionarVersao(documento.salvar());


        documento.editarConteudo(
                "Segunda alteração do documento."
        );

        System.out.println("ESTADO ATUAL");
        System.out.println(documento);

        documento.restaurar(
                historico.recuperarVersao(1)
        );

        System.out.println("VERSÃO RESTAURADA");
        System.out.println(documento);

        documento.restaurar(
                historico.recuperarVersao(0)
        );

        System.out.println("VERSÃO MAIS ANTIGA");
        System.out.println(documento);
    }
}