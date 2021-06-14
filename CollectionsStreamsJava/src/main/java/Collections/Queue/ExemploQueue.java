package Collections.Queue;


import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class ExemploQueue {
    public static void main(String[] args) {
        Queue<String> filaDeBanco = new LinkedList<>();

        filaDeBanco.add("Pamela");
        filaDeBanco.add("Patricia");
        filaDeBanco.add("Roberto");
        filaDeBanco.add("Fabio");



        filaDeBanco.add("Anderson");

        String clienteASerAtendido = filaDeBanco.poll();

        System.out.println(clienteASerAtendido);
        System.out.println(filaDeBanco);

        String primeiroCliente = filaDeBanco.peek();
        System.out.println(primeiroCliente);
        System.out.println(filaDeBanco);


        String primeiroClienteComErro = filaDeBanco.element();
        System.out.println(primeiroClienteComErro);
        System.out.println(filaDeBanco);

        for (String cliente: filaDeBanco){
            System.out.println("-->" + cliente);
        }

        Iterator<String> iteratorFiladeBanco = filaDeBanco.iterator();

        while(iteratorFiladeBanco.hasNext()) {
            System.out.println("**> " + iteratorFiladeBanco.next());
        }
        filaDeBanco.add("Carlos");
        System.out.println(filaDeBanco);


    }
}
