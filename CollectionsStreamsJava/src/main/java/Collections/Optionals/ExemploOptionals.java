package Collections.Optionals;

import java.util.Optional;

public class ExemploOptionals {
    public static void main(String[] args) {
        Optional<String> optionalSting = Optional.of("Valor Presente");

        System.out.println("Valor opcional que está presente");
        optionalSting.ifPresentOrElse(System.out::println, () -> System.out.println("não está presente"));



        Optional<String> optionalNull = Optional.ofNullable("Carla");
        System.out.println("Valor opcional que não está presente");
        optionalNull.ifPresentOrElse(System.out::println,() -> System.out.println("null = não está present"));


        Optional<String> emptyOptional = Optional.empty();


        System.out.println("Valor opcional não está presente");
        emptyOptional.ifPresentOrElse(System.out::println, ()-> System.out.println("empty = não está present"));


        /*
        Optional<String> optionalNullErro = Optional.of(null);


        System.out.println("Valor opcional que lança o erro NullPointerException");
        optionalNullErro.ifPresentOrElse(System.out::println, ()-> System.out.println("erro = não está presente"));

         */

    }
}
