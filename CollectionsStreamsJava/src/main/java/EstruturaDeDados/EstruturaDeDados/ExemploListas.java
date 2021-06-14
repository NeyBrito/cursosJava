package EstruturaDeDados;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class ExemploListas {

    public static void main(String[] args) {

        String aula1 = "Modelando a classe Aula";
        String aula2 = "Conhecendo mais de listas";
        String aula3 = "Trabalhando com Cursos e Sets";

        ArrayList<String> aulas = new ArrayList<>();
        aulas.add(aula1);
        aulas.add(aula2);
        aulas.add(aula3);

        System.out.println(aulas);
        System.out.println(aulas.size());

        aulas.remove(0);
        System.out.println(aulas);

        Collections.sort(aulas);

        // cuidado! <= faz sentido aqui?
        for (int i = 0; i <= aulas.size(); i++) {
            System.out.println("Aula: " + aulas.get(i));
        }
        for (String aula : aulas) {
            System.out.println("Aula: " + aula);
        }

        String primeiraAula = aulas.get(0);
        System.out.println("A primeira aula é " + primeiraAula);

        aulas.forEach(aula -> {
            System.out.println("Percorrendo:");
            System.out.println("Aula " + aula);
        });

    }
}