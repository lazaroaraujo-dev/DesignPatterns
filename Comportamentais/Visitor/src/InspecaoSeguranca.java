public class InspecaoSeguranca implements VisitanteSetor {

    @Override
    public void visitar(Armazem armazem) {

        System.out.println("Inspeção no Armazém");

        if (armazem.getQuantidadeEquipamentos() > 50) {
            System.out.println("Muitos equipamentos. Atenção à segurança.");
        } else {
            System.out.println("Armazém seguro.");
        }

        System.out.println();
    }

    @Override
    public void visitar(Administrativo administrativo) {

        System.out.println("Inspeção no Administrativo");
        System.out.println("Saídas de emergência verificadas.");

        System.out.println();
    }

    @Override
    public void visitar(Frota frota) {

        System.out.println("Inspeção na Frota");

        if (frota.isManutencaoEmDia()) {
            System.out.println("Veículos com manutenção em dia.");
        } else {
            System.out.println("Existem veículos com manutenção atrasada.");
        }

        System.out.println();
    }

    @Override
    public void visitar(Producao producao) {

        System.out.println("Inspeção na Produção");

        if (producao.isUsoEpi()) {
            System.out.println("Funcionários utilizando EPIs.");
        } else {
            System.out.println("Funcionários sem EPI.");
        }

        System.out.println();
    }
}