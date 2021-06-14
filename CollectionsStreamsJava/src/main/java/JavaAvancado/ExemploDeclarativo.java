package JavaAvancado;

import java.util.function.Function;

public class ExemploDeclarativo {
    public static void main(String[] args) {
        //Declarativo
        Function<Integer, Object> buscaUsuario = idUsuario ->
                new Object();
        System.out.println(buscaUsuario);

    }
    //Funcional
//    public static Object buscaUsuario(int idUsuario){
//        return Object();
//    }
}
