/**
 * Esta classe modela o aspecto funcional de uma calculadora b�sica, permitindo
 * realizar opera��es aritm�ticas fundamentais (soma, subtra��o, multiplica��o e
 * divis�o) envolvendo dois ou mais valores.
 * Nesta aplica��o esta classe desempenha o papel de Model no modelo MVC.
 * 
 * @author Leandro Fernandes
 */
public class CalculadoraModel {

	public static final int IGUAL         = 0;
	public static final int SOMA          = 1;
	public static final int SUBTRACAO     = 2;
	public static final int MULTIPLICACAO = 3;
	public static final int DIVISAO       = 4;

	private double operando1, operando2;
	private int operacao;

	public CalculadoraModel() {
		operando1 = 0;
		operando2 = 0;
		operacao = IGUAL;
	}
	
	public void setOperando(double valor) {
		this.operando2 = valor; 
	}
		
	public void setOperacao(int op) {
		this.operacao = op; 
	}
	
	/**
	 * Realiza o c�lculo de acordo com os valores e a opera��o previamente
	 * informados atrav�s dos m�todos setOperando(double) e setOperacao(int)
	 * @return resultado do c�lculo
	 * @throws ArithmeticException
	 */
	public double calcular() throws ArithmeticException {
		switch (operacao) {
		case IGUAL:
			operando1 = operando2;
			operando2 = 0;
			break;
		case SOMA:
			operando1 = operando1 + operando2;
			break;
		case SUBTRACAO:
			operando1 = operando1 - operando2;
			break;
		case MULTIPLICACAO:
			operando1 = operando1 * operando2;
			break;
		case DIVISAO:
			operando1 = operando1 / operando2;
			break;
		}
		return operando1;
	}

	/**
	 * Limpa o �ltimo operando informado, atribuindo valor zero a ele.
	 */
	public void limpaOperando() {
		operando2 = 0;
	}

	/**
	 * Zera todas as vari�veis da calculadora, sua opera��o e resultados
	 * parciais que tenham sido acumulados.
	 */
	public void limpaTudo() {
		operando1 = 0;
		operando2 = 0;
		operacao = IGUAL;		
	}
}
