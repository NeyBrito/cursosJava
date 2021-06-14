package Collections.Comparators;

import java.util.*;

public class ExemploComparatorList {
    public static void main(String[] args) {
        List<ExemploComparators> estudantes = new ArrayList<>();

        estudantes.add(new ExemploComparators("Pedro", 19));
        estudantes.add(new ExemploComparators("Carlos",23));
        estudantes.add(new ExemploComparators("Mariana", 21));
        estudantes.add(new ExemploComparators("João", 18));
        estudantes.add(new ExemploComparators("Thiago", 20));
        estudantes.add(new ExemploComparators("George", 22));
        estudantes.add(new ExemploComparators("Larissa", 21));

        System.out.println("----\n Ordem de Inserção ----");
        System.out.println(estudantes);

        estudantes.sort((first, second) -> first.getIdade() - second.getIdade());

        System.out.println("----\n Ordem natural dos números - idade ----");
        System.out.println(estudantes);

        estudantes.sort((first, second) -> second.getIdade() - first.getIdade());

        System.out.println("----\n Ordem reversa dos números - idade ----");
        System.out.println(estudantes);

        estudantes.sort(Comparator.comparingInt(ExemploComparators::getIdade));

        System.out.println("----\n Ordem natural dos números - idade (method reference) ----");
        System.out.println(estudantes);

        estudantes.sort(Comparator.comparingInt(ExemploComparators::getIdade).reversed());

        System.out.println("----\n Ordem reversa dos números - idade (method reference) ----");
        System.out.println(estudantes);

        Collections.sort(estudantes);

        System.out.println("----\n Odem natural dos números - idade (interface Comparable) ----");
        System.out.println(estudantes);

        Collections.sort(estudantes, new ExemploReversoComparator());
        System.out.println("---\n Ordem reversa dos números - idade (interface Comparator");


    }
}
