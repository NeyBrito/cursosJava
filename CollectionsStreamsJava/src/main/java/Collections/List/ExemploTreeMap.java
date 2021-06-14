package Collections.List;

import javax.swing.plaf.synth.SynthTextAreaUI;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class ExemploTreeMap {
    public static void main(String[] args) {
        TreeMap<String, String> treeCapitais = new TreeMap<>();

        treeCapitais.put("RS","Porto Alegre");
        treeCapitais.put("SC","Florianópolis");
        treeCapitais.put("PR","Curitiba");
        treeCapitais.put("SP","São Paulo");
        treeCapitais.put("RJ","Rio de Janeiro");
        treeCapitais.put("BH","Belo Horizonte");

        System.out.println(treeCapitais);

        System.out.println(treeCapitais.firstKey());
        System.out.println(treeCapitais.lastKey());
        System.out.println(treeCapitais.lowerKey("Florianópolis"));
        System.out.println(treeCapitais.higherKey("Florianópolis"));
        System.out.println(treeCapitais);

        System.out.println(treeCapitais.pollFirstEntry().getKey());
        System.out.println(treeCapitais.pollLastEntry());

        System.out.println(treeCapitais.lastEntry().getKey() + " -- " + treeCapitais.firstEntry().getValue());

        Iterator <String> iterator = treeCapitais.keySet().iterator();

        while (iterator.hasNext()){
            String key = iterator.next();
            System.out.println(key + " --- " + treeCapitais.get(key));
        }

        for (String capitais: treeCapitais.keySet()){
            System.out.println(capitais + " ---> " + treeCapitais.get(capitais));
        }

        for (Map.Entry<String, String> capitais: treeCapitais.entrySet()){
            System.out.println(capitais.getKey() + " **> " + capitais.getValue());
        }

    }
}
