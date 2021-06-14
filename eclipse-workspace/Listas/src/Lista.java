
import java.util.ArrayList;

public class Lista {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int tamanho;
		
		ArrayList lista = new ArrayList(10);
		System.out.println("Lista vazia -> " + lista);
		
		//Adicionar dados a lista;
		lista.add("1");
		lista.add("2");
		System.out.println("Lista -> " + lista);
		
		//Adicionar dado na posição 1 da lista;
		lista.add(1, "2");
		//Adicionando dado no final da lista;
		lista.add(3, "4");
		
		System.out.println("Lista -> " + lista);
		
		

	}

}
