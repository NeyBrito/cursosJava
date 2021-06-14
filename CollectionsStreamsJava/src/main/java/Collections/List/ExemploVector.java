package Collections.List;

import java.text.CollationElementIterator;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

public class ExemploVector {
    public static void main(String[] args) {
        List<String> esportes = new Vector<>();
        esportes.add("Futebol");
        esportes.add("Handbol");
        esportes.add("Bascketbol");

        Collections.sort(esportes);
        for (String intens: esportes){
            System.out.println("--->" + intens);
        }

        List<String> esportes2 = new Vector<>();
        esportes2.add("Voleibol");
        esportes2.add("Surf");
        Collections.sort(esportes2);
        for (String intens: esportes2){
            System.out.println("--->" + intens);
        }

        esportes.addAll(esportes2);
        System.out.println(esportes);

    }
}
