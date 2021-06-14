import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridBagLayout;

import javax.swing.JButton;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JTextField;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;

import javax.swing.SwingConstants;

/**
 * Esta classe implementa uma interface gráfica para a aplicação de uma 
 * calculadora básica, seguindo o modelo MVC e perfazendo o papel de View.
 * 
 * @author Leandro Fernandes
 *  
 *  +=======================+
 *  | Calculadora  _ [#][X] |
 *  +=======================+
 *  |  ___________________  |
 *  | [___________________] |
 *  |            ____  ___  |
 *  |           [_CE_][_C_] |
 *  |  ___  ___  ___   ___  |
 *  | [_7_][_8_][_9_] [_+_] |
 *  | [_4_][_5_][_6_] [_-_] |
 *  | [_1_][_2_][_3_] [_*_] |
 *  | [_0_][_,_][_=_] [_/_] |
 *  |                       |
 *  +=======================+
 */
@SuppressWarnings("serial")
public class CalculadoraUI extends JFrame
						   implements ActionListener
{

	private JPanel contentPane;
	private JTextField tfDisplay;
	private JButton btnCE, btnC, btnSom, btnSub, btnMul, btnDiv, btnIgual, btnSep,
					btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0;

	private boolean temVirgula, clearNext;
	
	/**
	 * Construtor.
	 * Método responsável por instanciar e construir toda o conteúdo da GUI,
	 * criando cada um de seus componentes e configurando suas propriedades. 
	 */
	public CalculadoraUI() {
		setResizable(false);
		setTitle("Calculadora");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 224, 249);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] {0, 0, 0, 10, 0, 0};
		gbl_contentPane.rowHeights = new int[] {40, 10, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		tfDisplay = new JTextField();
		tfDisplay.setBackground(SystemColor.controlLtHighlight);
		tfDisplay.setHorizontalAlignment(SwingConstants.RIGHT);
		tfDisplay.setText("1234567890");
		tfDisplay.setFont(new Font("Consolas", Font.PLAIN, 19));
		tfDisplay.setEditable(false);
		GridBagConstraints gbc_tfDisplay = new GridBagConstraints();
		gbc_tfDisplay.gridwidth = 5;
		gbc_tfDisplay.insets = new Insets(0, 0, 5, 0);
		gbc_tfDisplay.fill = GridBagConstraints.BOTH;
		gbc_tfDisplay.gridx = 0;
		gbc_tfDisplay.gridy = 0;
		contentPane.add(tfDisplay, gbc_tfDisplay);
		
		btnCE = new JButton("CE");
		btnCE.setActionCommand("clearE");
		GridBagConstraints gbc_btnCE = new GridBagConstraints();
		gbc_btnCE.anchor = GridBagConstraints.EAST;
		gbc_btnCE.gridwidth = 2;
		gbc_btnCE.insets = new Insets(0, 0, 5, 5);
		gbc_btnCE.gridx = 2;
		gbc_btnCE.gridy = 2;
		contentPane.add(btnCE, gbc_btnCE);
		
		btnC = new JButton("C");
		btnC.setActionCommand("clear");
		GridBagConstraints gbc_btnC = new GridBagConstraints();
		gbc_btnC.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnC.insets = new Insets(0, 0, 5, 0);
		gbc_btnC.gridx = 4;
		gbc_btnC.gridy = 2;
		contentPane.add(btnC, gbc_btnC);
		
		btn0 = new JButton("0");
		btn0.addActionListener(this);
		GridBagConstraints gbc_btn0 = new GridBagConstraints();
		gbc_btn0.insets = new Insets(0, 0, 0, 5);
		gbc_btn0.gridx = 1;
		gbc_btn0.gridy = 6;
		contentPane.add(btn0, gbc_btn0);
		
		btn1 = new JButton("1");
		btn1.addActionListener(this);
		GridBagConstraints gbc_btn1 = new GridBagConstraints();
		gbc_btn1.insets = new Insets(0, 0, 5, 5);
		gbc_btn1.gridx = 0;
		gbc_btn1.gridy = 5;
		contentPane.add(btn1, gbc_btn1);
		
		btn2 = new JButton("2");
		btn2.addActionListener(this);
		GridBagConstraints gbc_btn2 = new GridBagConstraints();
		gbc_btn2.insets = new Insets(0, 0, 5, 5);
		gbc_btn2.gridx = 1;
		gbc_btn2.gridy = 5;
		contentPane.add(btn2, gbc_btn2);
		
		btn3 = new JButton("3");
		btn3.addActionListener(this);
		GridBagConstraints gbc_btn3 = new GridBagConstraints();
		gbc_btn3.insets = new Insets(0, 0, 5, 5);
		gbc_btn3.gridx = 2;
		gbc_btn3.gridy = 5;
		contentPane.add(btn3, gbc_btn3);
		
		btn4 = new JButton("4");
		btn4.setMnemonic('4');
		btn4.addActionListener(this);
		GridBagConstraints gbc_btn4 = new GridBagConstraints();
		gbc_btn4.insets = new Insets(0, 0, 5, 5);
		gbc_btn4.gridx = 0;
		gbc_btn4.gridy = 4;
		contentPane.add(btn4, gbc_btn4);
		
		btn5 = new JButton("5");
		btn5.addActionListener(this);
		GridBagConstraints gbc_btn5 = new GridBagConstraints();
		gbc_btn5.insets = new Insets(0, 0, 5, 5);
		gbc_btn5.gridx = 1;
		gbc_btn5.gridy = 4;
		contentPane.add(btn5, gbc_btn5);
		
		btn6 = new JButton("6");
		btn6.addActionListener(this);
		GridBagConstraints gbc_btn6 = new GridBagConstraints();
		gbc_btn6.insets = new Insets(0, 0, 5, 5);
		gbc_btn6.gridx = 2;
		gbc_btn6.gridy = 4;
		contentPane.add(btn6, gbc_btn6);
		
		btn7 = new JButton("7");
		btn7.addActionListener(this);
		GridBagConstraints gbc_btn7 = new GridBagConstraints();
		gbc_btn7.insets = new Insets(0, 0, 5, 5);
		gbc_btn7.gridx = 0;
		gbc_btn7.gridy = 3;
		contentPane.add(btn7, gbc_btn7);
		
		btn8 = new JButton("8");
		btn8.addActionListener(this);
		GridBagConstraints gbc_btn8 = new GridBagConstraints();
		gbc_btn8.insets = new Insets(0, 0, 5, 5);
		gbc_btn8.gridx = 1;
		gbc_btn8.gridy = 3;
		contentPane.add(btn8, gbc_btn8);
		
		btn9 = new JButton("9");
		btn9.addActionListener(this);
		GridBagConstraints gbc_btn9 = new GridBagConstraints();
		gbc_btn9.insets = new Insets(0, 0, 5, 5);
		gbc_btn9.gridx = 2;
		gbc_btn9.gridy = 3;
		contentPane.add(btn9, gbc_btn9);
				
		btnSep = new JButton(".");
		btnSep.addActionListener(this);
		
		GridBagConstraints gbc_btnSep = new GridBagConstraints();
		gbc_btnSep.insets = new Insets(0, 0, 0, 5);
		gbc_btnSep.gridx = 0;
		gbc_btnSep.gridy = 6;
		contentPane.add(btnSep, gbc_btnSep);
		
		btnIgual = new JButton("=");
		btnIgual.setActionCommand("igual");
		GridBagConstraints gbc_btnIgual = new GridBagConstraints();
		gbc_btnIgual.insets = new Insets(0, 0, 0, 5);
		gbc_btnIgual.gridx = 2;
		gbc_btnIgual.gridy = 6;
		contentPane.add(btnIgual, gbc_btnIgual);
		
		btnSom = new JButton("+");
		btnSom.setActionCommand("soma");
		GridBagConstraints gbc_btnSom = new GridBagConstraints();
		gbc_btnSom.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnSom.insets = new Insets(0, 0, 5, 0);
		gbc_btnSom.gridx = 4;
		gbc_btnSom.gridy = 3;
		contentPane.add(btnSom, gbc_btnSom);
		
		btnSub = new JButton("-");
		btnSub.setActionCommand("subtração");
		GridBagConstraints gbc_btnSub = new GridBagConstraints();
		gbc_btnSub.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnSub.insets = new Insets(0, 0, 5, 0);
		gbc_btnSub.gridx = 4;
		gbc_btnSub.gridy = 4;
		contentPane.add(btnSub, gbc_btnSub);
		
		btnMul = new JButton("x");
		btnMul.setActionCommand("multiplicação");
		GridBagConstraints gbc_btnMul = new GridBagConstraints();
		gbc_btnMul.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnMul.insets = new Insets(0, 0, 5, 0);
		gbc_btnMul.gridx = 4;
		gbc_btnMul.gridy = 5;
		contentPane.add(btnMul, gbc_btnMul);
		
		btnDiv = new JButton("/");
		btnDiv.setActionCommand("divisão");
		GridBagConstraints gbc_btnDiv = new GridBagConstraints();
		gbc_btnDiv.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnDiv.gridx = 4;
		gbc_btnDiv.gridy = 6;
		contentPane.add(btnDiv, gbc_btnDiv);

		temVirgula = false;
	}

	/**
	 * Método que realiza o tratamento dos eventos associados aos botões numéricos
	 * para que sejam realizada a composição dos valores que serão usados no cálculo. 
	 */
	@Override
	public void actionPerformed(ActionEvent ae) {
		// Verifica se há necessidade de limpar o display antes de começar a compor um número
		if (clearNext) {
			limpaDisplay();
			clearNext = false;
		}

		// Se for o separador de decimal ...
		if (ae.getSource() == btnSep) {
			if(tfDisplay.getText().indexOf(".")>-1);
		    else tfDisplay.setText(tfDisplay.getText() + ".");

		}
		// senão, é qualquer um dos botões numéricos
		else {
			if (tfDisplay.getText().equals("0"))
				tfDisplay.setText( ((JButton) ae.getSource()).getText() );
			else
				tfDisplay.setText( tfDisplay.getText() + ((JButton) ae.getSource()).getText() );
		}
		
	}

	/**
	 * Método que apresenta um valor numérico inteiro no display da calculadora. 
	 * @param valor um número inteiro positivo ou negativo.
	 */
	public void setDisplay(int valor) {
		tfDisplay.setText(String.valueOf(valor));
	}
	
	/**
	 * Método que apresenta um valor numérico real no display da calculadora. 
	 * @param valor um número real positivo ou negativo.
	 */
	public void setDisplay(double valor) {
		tfDisplay.setText(String.valueOf(valor));
	}
	
	/**
	 * Retorna o valor numérico apresentado no display da calculadora.
	 * @return
	 */
	public double getDisplay() {
		return Double.parseDouble( tfDisplay.getText() );
	}

	/**
	 * Método auxiliar que zera o display da GUI.
	 */
	public void limpaDisplay() {
		tfDisplay.setText("0");
		temVirgula = false;
	}

	/**
	 * Método auxiliar que registra uma ação de limpar o display da GUI apenas
	 * quando o próximo digito for pressionado.
	 */
	public void limparDisplayNoProximo() {
		clearNext = true;
	}
	
	/**
	 * Método de conexão entre a interface gráfica (view) e o elemento
	 * que realiza o controle funcional dos botões aritméticos (que está 
	 * no model, mas é chamado através do control)
	 * @param controle listener que trata os eventos dos botões aritméticos
	 */
	public void setControle(ActionListener controle) {
		btnCE.addActionListener(controle);
		btnC.addActionListener(controle);
		btnSom.addActionListener(controle);
		btnSub.addActionListener(controle);
		btnMul.addActionListener(controle);
		btnDiv.addActionListener(controle);
		btnIgual.addActionListener(controle);
	}

}
