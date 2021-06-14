package Collections;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Exercicios {
    public static void main(String[] args) {
        Set<Integer> notasAlunos = new HashSet<>();

        notasAlunos.add(2);
        notasAlunos.add(4);
        notasAlunos.add(23);
        notasAlunos.add(14);
        notasAlunos.add(55);

        System.out.println(notasAlunos);

        notasAlunos.add(44);
        System.out.println(notasAlunos);
    }


}
