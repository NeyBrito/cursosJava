package one.aula1.FatorialRecursivo;

public class FatorialRecursivo {
    public static void main(String[] args) {
        System.out.println(fatorial(5));
    }

    public static int fatorial( int value ) {

        Funcao1 funcao1 = valor -> valor;

        if (value == 1) {
            return value;
        } else {

            int a =  value * fatorial((value - 1));
            System.out.println(value + " * " + (a));
            return a;

        }
    }

}

@FunctionalInterface
interface Funcao1{
    String gerar(String valor);
}

