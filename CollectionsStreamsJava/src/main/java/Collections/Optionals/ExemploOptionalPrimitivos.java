package Collections.Optionals;

import java.sql.SQLOutput;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;

public class ExemploOptionalPrimitivos {
    public static void main(String[] args) {
        System.out.println("***Valor inteiro presete***");
        OptionalInt.of(12).ifPresent(System.out::println);

        System.out.println("***Valor decimal presente***");
        OptionalDouble.of(55.0).ifPresent(System.out::println);


        System.out.println("***Valor longo opcional***");
        OptionalLong.of(23L).ifPresent(System.out::println);
    }
}
