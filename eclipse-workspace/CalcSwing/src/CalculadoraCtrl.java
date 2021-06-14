import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Classe que implementa a fun��o CONTROLLER no modelo MVC, realizando a
 * comunica��o entre a interface gr�fica (View) e a parte funcional da
 * calculadora (Model)
 * 
 * @author Leandro Fernandes
 *
 */
public class CalculadoraCtrl implements ActionListener {

	private CalculadoraUI calcGUI;
	private CalculadoraModel calcProcessador;

	/**
	 * M�todo que define qual � o elemento VIEW da aplica��o.
	 * @param modelo elemento que atua como Model no modelo MVC
	 */
	public void setView(CalculadoraUI janela) {
		calcGUI = janela;
		calcGUI.setControle(this);
	}

	/**
	 * M�todo que define qual � o elemento MODEL da aplica��o, que dever�
	 * implementar as regras de neg�cio da calculadora.
	 * @param modelo elemento que atua como Model no modelo MVC
	 */
	public void setModel(CalculadoraModel modelo) {
		calcProcessador = modelo;
	}

	/**
	 * M�todo de inicializa��o da aplica��o, gerido pelo elemento Control.
	 */
	public void init() {
		calcGUI.setDisplay(0);
		calcGUI.setVisible(true);
		calcProcessador.limpaTudo();
	}

	/**
	 * M�todo de realiza a comunica��o entre os elementos View e Model, cujo
	 * papel de ger�ncia transacional � realizado pelo Controller.
	 */
	@Override
	public void actionPerformed(ActionEvent ae) {
		// verifica se � o bot�o C (Clear)
		if (ae.getActionCommand().equals("clear")) {
			calcGUI.limpaDisplay();
			calcProcessador.limpaOperando();
		}
		// sen�o, verifica se � o bot�o CE (Clear and Empty)
		else if (ae.getActionCommand().equals("clearE")) {
			calcGUI.limpaDisplay();
			calcProcessador.limpaTudo();
		}
		// sen�o, verifica se � o bot�o '=' 
		else if (ae.getActionCommand().equals("igual")) {
			calcProcessador.setOperando(calcGUI.getDisplay());
			double resultado = calcProcessador.calcular();
			if (resultado - Math.floor(resultado) == 0)
				calcGUI.setDisplay((int) resultado);
			else
				calcGUI.setDisplay((double) resultado);
			calcProcessador.setOperacao(CalculadoraModel.IGUAL);
		}
		// sen�o, � porque um bot�o aritm�tico foi pressionado 
		else {
			calcProcessador.setOperando(calcGUI.getDisplay());
			double resultado = calcProcessador.calcular();
			if (resultado - Math.floor(resultado) == 0)
				calcGUI.setDisplay((int) resultado);
			else
				calcGUI.setDisplay((double) resultado);
			
			if (ae.getActionCommand().equals("soma"))
				calcProcessador.setOperacao(CalculadoraModel.SOMA);				
			else if (ae.getActionCommand().equals("subtra��o"))
				calcProcessador.setOperacao(CalculadoraModel.SUBTRACAO);
			else if (ae.getActionCommand().equals("multiplica��o"))
				calcProcessador.setOperacao(CalculadoraModel.MULTIPLICACAO);
			else if (ae.getActionCommand().equals("divis�o"))
				calcProcessador.setOperacao(CalculadoraModel.DIVISAO);
			
			calcGUI.limparDisplayNoProximo();
		}
	}

}