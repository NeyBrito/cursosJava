import javax.swing.*;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExemException {

	public static void main(String[] args) {
		Scanner tcl = new Scanner(System.in);
		int num1 = 0, num2 = 0, result = 0;
		
		System.out.println("Informe um numero inteiro: ");
		num1 = tcl.nextInt();
		System.out.println("Agora informe mais um valor: ");
		num2 = tcl.nextInt();

		try{
		result = num1 / num2;
		} 				
		catch(ArithmeticException e){
			JOptionPane.showMessageDialog(null, "Não dividirás por zero!");
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
		 catch (InputMismatchException e){
		   	JOptionPane.showMessageDialog(null, "Ops. Informe um número!");
		    System.err.println(e.getMessage());
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, "Valor inválido.");
			System.err.println(e.getMessage());
		}
				
	     System.out.println("Resultado: " + num1 + " / " + num2 + " = " + result);
	}
}


