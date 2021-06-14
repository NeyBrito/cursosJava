package one.aula2;

import java.util.function.Supplier;

public class Suplidores {
    public static void main(String[] args) {
        Supplier<Pessoa> instanciaPessoa = () -> new Pessoa();
        Supplier<Pessoa> instanciaPessoa2 = Pessoa::new;
        System.out.println(instanciaPessoa.get());
        System.out.println(instanciaPessoa2.get());
    }
}


//Classe
class Pessoa {
    private String nome;
    private Integer idade;
//Construtor
    public Pessoa() {
        nome = "joao";
        idade = 23;
    }
//ToString para ver a String
    @Override
    public String toString() {
        return String.format("nome : %s, idade: %d",nome,idade) ;
    }
}
