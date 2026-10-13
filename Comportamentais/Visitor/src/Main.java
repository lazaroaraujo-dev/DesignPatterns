import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Setor> setores = new ArrayList<>();

        setores.add(new Armazem(60, false));
        setores.add(new Administrativo(20, true));
        setores.add(new Frota(15, false));
        setores.add(new Producao(8, true));

        VisitanteSetor inspecao = new InspecaoSeguranca();
        VisitanteSetor limpeza = new AvaliacaoLimpeza();

        System.out.println("===== INSPEÇÃO DE SEGURANÇA =====");

        for (Setor setor : setores) {
            setor.aceitar(inspecao);
        }

        System.out.println("===== AVALIAÇÃO DE LIMPEZA =====");

        for (Setor setor : setores) {
            setor.aceitar(limpeza);
        }
    }
}