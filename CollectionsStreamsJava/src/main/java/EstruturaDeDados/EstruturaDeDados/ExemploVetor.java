package EstruturaDeDados;

import java.lang.reflect.Array;

import java.util.Scanner;

public class ExemploVetor {
    public static void main(String[] args) {
        int ar[] = {4,5,7,3,2};
        Scanner sc = new Scanner(System.in);
        System.out.println("Qual número quer encontrar: ");
        int numero = sc.nextInt();

        for(int i = 0; i < ar.length; i++){
            if (ar[i]== numero) {
                System.out.println("Numero está na posição: " + i);
            }
        }

    }
}
