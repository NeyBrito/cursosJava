package Collections.Set;

import java.util.LinkedHashSet;

public class ExemploLinkedHashSet {
    public static void main(String[] args) {
        LinkedHashSet<Integer> sequenciaNumerica = new java.util.LinkedHashSet<>();

        sequenciaNumerica.add(5);
        sequenciaNumerica.add(9);
        sequenciaNumerica.add(6);
        sequenciaNumerica.add(10);
        sequenciaNumerica.add(5);
        sequenciaNumerica.add(7);
        sequenciaNumerica.add(3);
        sequenciaNumerica.add(4);

        sequenciaNumerica.remove(4);
        System.out.println(sequenciaNumerica);

    }
}
