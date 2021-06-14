package one.aula2;

import java.util.Scanner;

public class FuncaoAltaOrdem {
    public static void main(String[] args) {
        Calculo SOMA =  (a, b) -> a+b;
        Calculo SUBTRACAO = (a,b) -> a - b;
        Calculo MULTIPLICACAO = (a,b) -> a * b;
        Calculo DIVISAO = (a,b) -> a / b;
        System.out.println("Resultado da soma: " + executarOperacao(SOMA,0,0));
        System.out.println("Resultado da subtração: " + executarOperacao(SUBTRACAO,0,0));
        System.out.println("Resultado da multiplicação: " +executarOperacao(MULTIPLICACAO,0,0));
        System.out.println("Resultado da divisão: " +executarOperacao(DIVISAO,0,0));
    }

    public static int executarOperacao(Calculo calculo, int a, int b){
        Scanner sc = new Scanner(System.in);

        //Pega os valores digitado pelo usuário
        for(int i = 1; i < 3; i++){
            System.out.print("Digite o " + i + "º valor: ");
            if(a == 0){
                a = sc.nextInt();
            }else{
                b = sc.nextInt();
            }

        }
        return calculo.calcular(a,b);
    }
}

@FunctionalInterface
interface Calculo {

    public int calcular(int a, int b);

}