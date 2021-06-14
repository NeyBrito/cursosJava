/**
 * Este programa implementa calculadora básica com interface gráfica
 * e seguindo o modelo MVC em sua arquitetura.
 * 
 * @author Leandro Fernandes
 */
public class Calculadora {

	public static void main(String[] args) {
		
		// Criando cada uma das partes do modelo M-V-C
		CalculadoraModel modelo = new CalculadoraModel();	// Model
		CalculadoraUI janela = new CalculadoraUI();			// View
		CalculadoraCtrl ctrl = new CalculadoraCtrl();		// Control
		
		// Conectando o control ...
		ctrl.setView(janela);	// com a View, e
		ctrl.setModel(modelo);	// com o Model
		
		// Iniciando a aplicação
		ctrl.init();
	}

}