package Collections.API;

import java.util.*;
import java.util.stream.Collectors;

public class ExemploAPI {
    public static void main(String[] args) {
        List<String> nomes = new ArrayList<>();

        nomes.add("Ney");
        nomes.add("Diogo");
        nomes.add("Maria");
        nomes.add("João");

        //Conta numero de Elementos
        System.out.println("Contagem: " + nomes.stream().count());

        //Verifica o elemento com maior numero de letras
        System.out.println("Maior numero de letras: " + nomes.stream().max(Comparator.comparingInt(String::length)));

        //Verifica o elemento com minimo numero de letras
        System.out.println("Maior numero de letras: " + nomes.stream().min(Comparator.comparingInt(String::length)));

        //Verifica elementos com letra R
        System.out.println("Com letra r no nome: " + nomes.stream().filter((nome)->
                nome.toLowerCase().contains("r")).collect(Collectors.toList()));

        //Retorna uma nova coleção com os nomes concatenados e quantidade de letra de cada nome
        System.out.println("Retorna uma nova coleção com a quantidade de letras:  "+ nomes.stream().map(nome ->
                nome.concat("<->").concat(String.valueOf(nome.length()))).collect(Collectors.toList()));

        //Rerona somente os 3 primeiros elementos da coleção
        System.out.println("Retorna os 3 primeiros elementos " + nomes.stream().limit(3).collect(Collectors.toList()));

        //Exibe cada elemento no console e depois retorna a mesma coleção
        System.out.println("Retorna elementos: " + nomes.stream().peek(System.out::println).collect((Collectors.toList())));

        //Exibe cada elemento no console sem retornar outra coleção
        System.out.println("Retorna elementos novamento: ");
        nomes.stream().forEach(System.out::println);

        //Todos os elementostem que ter a letra N
        System.out.println("Tem algum elemento com a letra N? \n -> " + nomes.stream().allMatch((elemento) ->
                elemento.toLowerCase().contains("n")));

        //Se um elemento tiver N retorna true
        System.out.println("Tem algum elemento com a letra N? \n -> " + nomes.stream().anyMatch((elemento) ->
                elemento.toLowerCase().contains("n")));

        //Se um elemento tiver N retorna true
        System.out.println("Tem algum elemento com a letra N? \n -> " + nomes.stream().noneMatch((elemento) ->
                elemento.toLowerCase().contains("n")));
        System.out.println("Tem algum elemento com a letra N? \n ->-_-> " + nomes.stream().noneMatch((elemento) ->
                elemento.length() >= 10));

        //Retorna o primeiro elemento da coleção, se existir exibe no console
        System.out.println("Retorna o primeiro elemento da coleção");
        nomes.stream().findFirst().ifPresent(System.out::println);


        //Exemplo de operação encadeada
        System.out.println("Operação encadeada: ");
        System.out.println(nomes.stream()
                .peek(System.out::println)
                .map(nome ->
                        nome.concat(":").concat(String.valueOf(nome.length())))
                .peek(System.out::println)
                .filter((nome) ->
                        nome.toLowerCase().contains("o"))
//              .collect(Collectors.toList())
                .collect(Collectors.groupingBy(nome -> nome.substring(nome.indexOf(":") + 1))));
        //pega o primeiro valor e tranforma em indice
//              .collect(Collectors.groupingBy(nome -> nome.substring(0,1);




    }
}
