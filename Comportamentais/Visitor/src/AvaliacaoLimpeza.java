public class AvaliacaoLimpeza implements VisitanteSetor {

    @Override
    public void visitar(Armazem armazem) {

        System.out.println("Avaliação de limpeza no Armazém");

        if (armazem.isOrganizado()) {
            System.out.println("Armazém organizado.");
        } else {
            System.out.println("Armazém desorganizado.");
        }

        System.out.println();
    }

    @Override
    public void visitar(Administrativo administrativo) {

        System.out.println("Avaliação de limpeza no Administrativo");
        System.out.println("Mesas e documentos avaliados.");

        System.out.println();
    }

    @Override
    public void visitar(Frota frota) {

        System.out.println("Avaliação de limpeza na Frota");
        System.out.println("Veículos avaliados.");

        System.out.println();
    }

    @Override
    public void visitar(Producao producao) {

        System.out.println("Avaliação de limpeza na Produção");

        if (producao.getNivelRisco() > 7) {
            System.out.println("Área exige limpeza reforçada.");
        } else {
            System.out.println("Limpeza adequada.");
        }

        System.out.println();
    }
}