package Collections.List;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Map;

public class ExemploMap {
    public static void main(String[] args) {
        Map<String, Integer> campeoesMundialFifa = new HashMap<>();

        campeoesMundialFifa.put("Brasil", 5);
        campeoesMundialFifa.put("Alemanha", 4);
        campeoesMundialFifa.put("Itália", 4);
        campeoesMundialFifa.put("Uruguai", 2);
        campeoesMundialFifa.put("Argentina", 2);
        campeoesMundialFifa.put("França", 2);
        campeoesMundialFifa.put("Inglaterra", 1);
        campeoesMundialFifa.put("Espanha", 1);

        System.out.println(campeoesMundialFifa);
        //Atualiza valor do Brasil
        campeoesMundialFifa.put("Brasl", 6);
        //Retorna se há ou não um valor
        System.out.println(campeoesMundialFifa.get("Argentina"));
        //Verifica se tem essa chave
        System.out.println(campeoesMundialFifa.containsKey("França"));
        //Remove o campeão França
        System.out.println(campeoesMundialFifa.remove("França"));
        //Retorna se existem alguem com 6
        System.out.println(campeoesMundialFifa.containsValue(6));

        System.out.println(campeoesMundialFifa.size());

        System.out.println(campeoesMundialFifa);

        //Navega nos itens do Map
        for (Map.Entry<String, Integer> entry: campeoesMundialFifa.entrySet()){
            System.out.println(entry.getKey() + " -- " + entry.getValue());
        }

        for (String key: campeoesMundialFifa.keySet()){
            System.out.println(key + " --> " + campeoesMundialFifa.get(key));
        }

        System.out.println(campeoesMundialFifa.containsKey("Estados Unidos"));









    }
}
