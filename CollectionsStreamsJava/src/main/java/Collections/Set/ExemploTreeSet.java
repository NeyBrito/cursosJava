package Collections.Set;

import java.sql.SQLOutput;
import java.util.Iterator;
import java.util.TreeSet;

public class ExemploTreeSet {
    public static void main(String[] args) {
        TreeSet<String> treeCapitais = new TreeSet<>();

        treeCapitais.add("Porto Alegre");
        treeCapitais.add("Florianópolis");
        treeCapitais.add("Curitiba");
        treeCapitais.add("São Paulo");
        treeCapitais.add("Rio de Janeiro");
        treeCapitais.add("Belo Horizonte");

        System.out.println(treeCapitais);

        System.out.println(treeCapitais.first());
        System.out.println(treeCapitais.last());
        System.out.println(treeCapitais.lower("Florianópolis"));
        System.out.println(treeCapitais.higher("Florianópolis"));
        System.out.println(treeCapitais);

        System.out.println(treeCapitais.pollFirst());
        System.out.println(treeCapitais.pollLast());

        Iterator<String> iterator = treeCapitais.iterator();

        while(iterator.hasNext()){
            System.out.println("---> " + iterator.next());
        }


    }
}
