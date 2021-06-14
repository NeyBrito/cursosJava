import java.util.Scanner;

public class Interativa {

	public static void main(String[] args) {
		int n, k, soma = 0;
		
		Scanner sc1 = new Scanner(System.in); 
		System.out.println("Digite o numero de elementos: ");
		n = sc1.nextInt();
		
		System.out.println("Digite o expoente: ");
		k = sc1.nextInt();		
		
		for (int i = 0; i<n+1; i++) {
			soma+= Math.pow(i, k);
		}		
		System.out.println(soma);
	}
}
