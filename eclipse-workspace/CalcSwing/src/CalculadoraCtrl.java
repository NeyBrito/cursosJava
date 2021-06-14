import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Classe que implementa a função CONTROLLER no modelo MVC, realizando a
 * comunicação entre a interface gráfica (View) e a parte funcional da
 * calculadora (Model)
 * 
 * @author Leandro Fernandes
 *
 */
public class CalculadoraCtrl implements ActionListener {

	private CalculadoraUI calcGUI;
	private CalculadoraModel calcProcessador;

	/**
	 * Método que define qual é o elemento VIEW da aplicação.
	 * @param modelo elemento que atua como Model no modelo MVC
	 */
	public void setView(CalculadoraUI janela) {
		calcGUI = janela;
		calcGUI.setControle(this);
	}

	/**
	 * Método que define qual é o elemento MODEL da aplicação, que deverá
	 * implementar as regras de negócio da calculadora.
	 * @param modelo elemento que atua como Model no modelo MVC
	 */
	public void setModel(CalculadoraModel modelo) {
		calcProcessador = modelo;
	}

	/**
	 * Método de inicialização da aplicação, gerido pelo elemento Control.
	 */
	public void init() {
		calcGUI.setDisplay(0);
		calcGUI.setVisible(true);
		calcProcessador.limpaTudo();
	}

	/**
	 * Método de realiza a comunicação entre os elementos View e Model, cujo
	 * papel de gerência transacional é realizado pelo Controller.
	 */
	@Override
	public void actionPerformed(ActionEvent ae) {
		// verifica se é o botão C (Clear)
		if (ae.getActionCommand().equals("clear")) {
			calcGUI.limpaDisplay();
			calcProcessador.limpaOperando();
		}
		// senão, verifica se é o botão CE (Clear and Empty)
		else if (ae.getActionCommand().equals("clearE")) {
			calcGUI.limpaDisplay();
			calcProcessador.limpaTudo();
		}
		// senão, verifica se é o botão '=' 
		else if (ae.getActionCommand().equals("igual")) {
			calcProcessador.setOperando(calcGUI.getDisplay());
			double resultado = calcProcessador.calcular();
			if (resultado - Math.floor(resultado) == 0)
				calcGUI.setDisplay((int) resultado);
			else
				calcGUI.setDisplay((double) resultado);
			calcProcessador.setOperacao(CalculadoraModel.IGUAL);
		}
		// senão, é porque um botão aritmético foi pressionado 
		else {
			calcProcessador.setOperando(calcGUI.getDisplay());
			double resultado = calcProcessador.calcular();
			if (resultado - Math.floor(resultado) == 0)
				calcGUI.setDisplay((int) resultado);
			else
				calcGUI.setDisplay((double) resultado);
			
			if (ae.getActionCommand().equals("soma"))
				calcProcessador.setOperacao(CalculadoraModel.SOMA);				
			else if (ae.getActionCommand().equals("subtração"))
				calcProcessador.setOperacao(CalculadoraModel.SUBTRACAO);
			else if (ae.getActionCommand().equals("multiplicação"))
				calcProcessador.setOperacao(CalculadoraModel.MULTIPLICACAO);
			else if (ae.getActionCommand().equals("divisão"))
				calcProcessador.setOperacao(CalculadoraModel.DIVISAO);
			
			calcGUI.limparDisplayNoProximo();
		}
	}

}