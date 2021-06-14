package Collections.List;

import java.util.*;

public class ExemploList {
    public static void main(String[] args) {
        List<String> nomes = new ArrayList<>();

        nomes.add("Ney");
        nomes.add("Diogo");
        nomes.add("Maria");
        nomes.add("João");

        System.out.println(nomes);
        Collections.sort(nomes);
        System.out.println(nomes);

        nomes.set(2,"André");
        Collections.sort(nomes);
        System.out.println(nomes);

        nomes.remove(2);
        System.out.println(nomes);

        String nome = nomes.get(0);
        System.out.println(nome);

        int posicao = nomes.indexOf("Ney");
        System.out.println(posicao);

        int tamanho = nomes.size();
        System.out.println(tamanho);

        boolean temAndre = nomes.contains("André");
        System.out.println(temAndre);

        for (String nomeItem: nomes){
            System.out.println("--> " + nomeItem);
        }

        Iterator<String > iterator = nomes.iterator();

        while (iterator.hasNext()){
            System.out.println("---->" + iterator.next());
        }

        nomes.clear();

        boolean listVazia = nomes.isEmpty();
        System.out.println(listVazia);


    }
}
