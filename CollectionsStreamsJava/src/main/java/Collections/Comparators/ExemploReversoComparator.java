package Collections.Comparators;

import Collections.Comparators.ExemploComparators;

import java.util.Comparator;

public class ExemploReversoComparator implements Comparator<ExemploComparators> {
    @Override
    public int compare(ExemploComparators o1, ExemploComparators o2){
        return o2.getIdade() - o1.getIdade();
    }

}
