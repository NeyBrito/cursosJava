package one;

import java.util.Scanner;

class AltaOrdem {
    public static void main(String[] args) {
        Calculo soma = (a,b) -> a+b;

        System.out.println("Resultado da soma é: " + executarOperacao(soma,0,0));
    }

    public static int  executarOperacao(Calculo calculo, int a, int b){
        Scanner sc = new Scanner(System.in);
        for(int i = 1; i <3; i++){
            System.out.print("Digite o "+ i + "º valor: ");
            if(a == 0){
                a = sc.nextInt();
            }else{
                b = sc.nextInt();
            }
        }
        return calculo.somar(a,b);
    }
}
interface Calculo{
    public int somar(int a, int b);
    Scanner sc = new Scanner(System.in);


}
