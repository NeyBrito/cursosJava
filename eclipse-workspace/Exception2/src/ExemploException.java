
import javax.swing.*;

import java.util.Scanner;
 public class ExemploException {
	public static void mains(String[] args){
		Scanner tcl = new Scanner(System.in);
		int num1 = 0, num2 = 0, result;		
		System.out.print("Informe um numero inteiro: ");
		num1=tcl.nextInt();		
		
		System.out.print("Agora, informe mais um valor: ");
		result = num1/num2;
		System.exit(0);
	}

}
