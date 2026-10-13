import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Questao> questoesBase = new ArrayList<>();
        questoesBase.add(new Questao("Q1", "Explique o que é um objeto.", 3));
        questoesBase.add(new Questao("Q2", "Explique o que é encapsulamento", 3));
        questoesBase.add(new Questao("Q3", "Explique como funciona o Prototype.", 4));

        Prova template = new Prova(
                "Prova POO - Template",
                "TEMPLATE",
                "2026-03-10",
                "BASE",
                questoesBase
        );

        System.out.println(" TEMPLATE ");
        template.printResumo();

        Prova prova1 = template.copiar();
        prova1.setTurma("2º INFO A");
        prova1.setData("2026-03-20");
        prova1.setVersao("V1");
        prova1.substituirQuestao("Q2",
                new Questao("Q2", "Explique o que é uma classe.", 3));

        System.out.println("=== PROVA 1 ===");
        prova1.printResumo();

        Prova prova2 = template.copiar();
        prova2.setTurma("2º INFO B");
        prova2.setData("2026-03-21");
        prova2.setVersao("V1");
        prova2.substituirQuestao("Q3",
                new Questao("Q3", "Explique o que é uma classe abstrata.", 5));

        System.out.println("=== PROVA 2 ===");
        prova2.printResumo();

        prova1.substituirQuestao("Q1",
                new Questao("Q1", "Explique de modo simplificado o conceito de herança e polimorfismo.", 3));

        System.out.println(" TEMPLATE APÓS ALTERAÇÃO NA PROVA 1 ");
        template.printResumo();

        System.out.println(" PROVA 1 APÓS ALTERAÇÃO ");
        prova1.printResumo();
    }
}