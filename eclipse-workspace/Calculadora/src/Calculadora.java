import java.awt.*;

import java.awt.event.*;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Calculadora extends Frame implements WindowListener{
	
	private static final long serialVersionUID = 1L; //Pediu para setar automaticamente;
	private Button btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9;
	private Button btnVir,btnC,btnCE,btnAdc,btnSub,btnDiv,btnMult,btnIgual;
	private JTextField tfVisor;
	private double valor;
	private int result = 0;
	private double operacao;
	boolean clickSomar=false, clickSub=false, clickMult=false, clickDiv=false;

	
	/*Construtor*/
	public Calculadora() {
		btn0 = new Button("0");
		btn1 = new Button("1");
		btn2 = new Button("2");
		btn3 = new Button("3");
		btn4 = new Button("4");
		btn5 = new Button("5");
		btn6 = new Button("6");
		btn7 = new Button("7");
		btn8 = new Button("8");
		btn9 = new Button("9");
		btnVir = new Button(".");
		btnC = new Button("C");
		btnCE = new Button("CE");
		btnAdc = new Button("+");
		btnSub = new Button("-");
		btnDiv = new Button("/");
		btnMult = new Button("*");
		btnIgual = new Button("=");
		tfVisor = new JTextField();
		
		/*Definindo priedades*/
		btn0.setActionCommand("0");
		btn1.setActionCommand("1");
		btn2.setActionCommand("2");
		btn3.setActionCommand("3");
		btn4.setActionCommand("4");
		btn5.setActionCommand("5");
		btn6.setActionCommand("6");
		btn7.setActionCommand("7");
		btn8.setActionCommand("8");
		btn9.setActionCommand("9");
		btnVir.setActionCommand(",");
		btnC.setActionCommand("Apagar");
		btnCE.setActionCommand("Apagar");	
		btnAdc.setActionCommand("Soma");
		btnSub.setActionCommand("Subtração");
		btnDiv.setActionCommand("Divisão");
		btnMult.setActionCommand("Multiplicação");
		btnIgual.setActionCommand("Igual");
		
		/*prp.relacionadas a janela*/
    	this.setTitle("Calculadora NEY");
    	this.setSize(225,310);
    	this.setResizable(false);
		
		/*Posicionando container*/		
        this.addWindowListener(this);
		
		this.add(btnVir);
		btnVir.setBounds(65,255,40,35);				
		CInterna objInner = new CInterna();	//Cria um objeto do tipo CInterna; 	
        btnVir.addActionListener(objInner); //Seta o BtnVir para executar a ação da classe Cinterna;
        
        this.add(tfVisor);
		tfVisor.setBounds(20,50,185,25);
		tfVisor.setHorizontalAlignment(JTextField.RIGHT); //Alinha o texto a direita do TextField. Só consegui com o JTextFiel;;
	    tfVisor.setEditable(false);/*Setei o textfield como não editavel para não aceitar letras,
		porém quando editavel, se por letras no text field ele entra na exceção e diz que não tem uma valor visor*/
		
		this.setLayout(null);
		
		this.add(btn0);
		btn0.setBounds(20,255,40,35);
		btn0.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
            	if(tfVisor.getText().equals("0")) {//Verifica se tem 0 no TxtField;
            	    tfVisor.setText(tfVisor.getText() + "");//Se já tiver não deixa por mais;
            	}else {
            		tfVisor.setText(tfVisor.getText() + "0");//Se caso tiver põe um;
            	}
    
            }
        });
		
		//Números;
		this.add(btn1);
		btn1.setBounds(20,135,40,35);
		btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	if(tfVisor.getText().equals("0")) {//Verifica se tem 0 no TxtFiel;
            		tfVisor.setText("1");//Substitui o 0 pelo 1;
                }else {
                	tfVisor.setText(tfVisor.getText() + "1");//Se caso não tiver 0. Seta btn1 para mostrar no visor o valor 1;
                }
             
            }
        });		
		
		this.add(btn2);
		btn2.setBounds(65,135,40,35);
		btn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {            	
            	if(tfVisor.getText().equals("0")) {
            		tfVisor.setText("2");
                }else {
                	tfVisor.setText(tfVisor.getText() + "2");
                }
            }
            
        });		
		
		this.add(btn3);
		btn3.setBounds(110,135,40,35);
		btn3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	if(tfVisor.getText().equals("0")) {
            		tfVisor.setText("3");
                }else {
                	tfVisor.setText(tfVisor.getText() + "3");
                }
            }
            
        });		
		
		this.add(btn4);
		btn4.setBounds(20,175,40,35);
		btn4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	if(tfVisor.getText().equals("0")) {
            		tfVisor.setText("4");
                }else {
                	tfVisor.setText(tfVisor.getText() + "4");
                }
            }
            
        });		
		
		this.add(btn5);
		btn5.setBounds(65,175,40,35);
		btn5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	if(tfVisor.getText().equals("0")) {
            		tfVisor.setText("5");
                }else {
                	tfVisor.setText(tfVisor.getText() + "5");
                }
            }
        });		
		
		this.add(btn6);
		btn6.setBounds(110,175,40,35);
		btn6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	if(tfVisor.getText().equals("0")) {
            		tfVisor.setText("6");
                }else {
                	tfVisor.setText(tfVisor.getText() + "6");
                }
            }
        });		
		
		this.add(btn7);
		btn7.setBounds(20,215,40,35);
		btn7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	if(tfVisor.getText().equals("0")) {
            		tfVisor.setText("7");
                }else {
                	tfVisor.setText(tfVisor.getText() + "7");
                }
            }
        });		
	
		this.add(btn8);
		btn8.setBounds(65,215,40,35);
		btn8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	if(tfVisor.getText().equals("0")) {
            		tfVisor.setText("8");
                }else {
                	tfVisor.setText(tfVisor.getText() + "8");
                }
            }
        });		
		
		this.add(btn9);
		btn9.setBounds(110,215, 40,35);
		btn9.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	if(tfVisor.getText().equals("0")) {
            		tfVisor.setText("9");
                }else {
                	tfVisor.setText(tfVisor.getText() + "9");
                }
            }
        });		
		//Seta o ctnC para mostrar o valor 0;
		this.add(btnC);
		btnC.setBounds(165,85,40,35);
		 btnC.addActionListener(new ActionListener()
	        {
	            public void actionPerformed(ActionEvent ae)
	            {
	                tfVisor.setText("0");
	            }
	        });		
		//Seta o btnCE para limpar a tela;
		this.add(btnCE);
		btnCE.setBounds(110,85,40,35);
		btnCE.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
            	  {
  	                tfVisor.setText("");
  	              }          	               
            }
        });	
		     //Btn Adição;	
		
	    	this.add(btnAdc);
			btnAdc.setBounds(165,135,40,35);
			
     		btnAdc.addActionListener(new ActionListener() {
			   public void actionPerformed(ActionEvent ae) {
				    try{//Tenta fazer o envento de pegar o valor após clicar no btnAdc;
					    valor = Double.parseDouble(tfVisor.getText());//Atribui o valor do TxtField a variável valor;
					    tfVisor.setText("");//Limpa o visor para entrar o outro valor;	
					    clickSomar = true;
					}catch(NumberFormatException e){//Se caso não tiver nenhum valor no visor e lança o erro;
							JOptionPane.showMessageDialog(null, "Não tem nenhum valor no visor");
							System.err.println(e.getMessage());//Printar o tipo do erro (No caso string Vazia);
							//e.printStackTrace();
							tfVisor.setText("0");//Seta o texto do visor como 0, para entrar no operação;
					}
					
				}                 
		    });
     		
			this.add(btnSub);
			btnSub.setBounds(165,175,40,35);
			btnSub.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent ae) {
	            	try{
	            	valor = Double.parseDouble(tfVisor.getText());
	            	tfVisor.setText("");
	            	clickSub = true;
	            	}catch(NumberFormatException e){//Se caso não tiver nenhum valor no visor e lança o erro;
						JOptionPane.showMessageDialog(null, "Não tem nenhum valor no visor");
						System.err.println(e.getMessage());
						//e.printStackTrace();
						tfVisor.setText("0");
				    }
	            }                 
	        });
			
			this.add(btnDiv);
			btnDiv.setBounds(165,215,40,35);
			btnDiv.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent ae) {
	            	try {
	            	valor = Double.parseDouble(tfVisor.getText());  
	            	tfVisor.setText("");
	            	clickDiv = true;
	            	}catch(NumberFormatException e){//Se caso não tiver nenhum valor no visor e lança o erro;
						JOptionPane.showMessageDialog(null, "Não tem nenhum valor no visor");
						System.err.println(e.getMessage());
						//e.printStackTrace();
						tfVisor.setText("0");
				   }
	            }                 
	        });
			
			this.add(btnMult);
			btnMult.setBounds(165,255,40,35);
			btnMult.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent ae) {
	            	try {
	            	valor = Double.parseDouble(tfVisor.getText());  
	            	tfVisor.setText("");
	            	clickMult = true;
	            	}catch(NumberFormatException e){//Se caso não tiver nenhum valor no visor e lança o erro;
						JOptionPane.showMessageDialog(null, "Não tem nenhum valor no visor");
						System.err.println(e.getMessage());
						//e.printStackTrace();
						tfVisor.setText("0");
				   }
	            }                 
	        });		    
						
        /*Configuração botão igual*/
		this.add(btnIgual);
		btnIgual.setBounds(110,255,40,35);
		btnIgual.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
            	if(clickSomar == true){ //Verifica se foi clicado no botão soma;	
            		 operacao = valor + Double.parseDouble(tfVisor.getText());//Pega a variavel valor atribuida na operação, converte o valor do text field para double e soma;
            		 result = (int) operacao;//Atribui a parte interira da variavel operacao a result;
            		 if(operacao == result) {//Se a operação for igual a parte inteira mostra a variavel result só com a parte inteira.
            			 tfVisor.setText(Integer.toString(result));//Mostra o resultado da operação no visor; 
            		 }else {//Se não mostra a variavel operacao;
            			 tfVisor.setText(Double.toString(operacao));//Mostra o resultado da operação no visor
            		 }            		                 	            	 
                 	 clickSomar = false;//Desativa o botão para aceitar novas operações;
                }
            	
            	if(clickSub == true) {
            		 operacao = valor - Double.parseDouble(tfVisor.getText());
            		 result = (int) operacao;
            		 if(operacao == result) {
            			 tfVisor.setText(Integer.toString(result));//Mostra o resultado da operação no visor; 
            		 }else {
            			 tfVisor.setText(Double.toString(operacao));//Mostra o resultado da operação no visor
            		 } 
                 	 clickSub = false;                 	 
            	}
            	
            	if(clickMult == true) {
           		     operacao = valor * Double.parseDouble(tfVisor.getText());
           		     result = (int) operacao;
         		     if(operacao == result) {
         			     tfVisor.setText(Integer.toString(result));//Mostra o resultado da operação no visor; 
         		     }else {
         			     tfVisor.setText(Double.toString(operacao));//Mostra o resultado da operação no visor
         		     } 
                	 clickMult = false; 
           	    }
            	
            	if(clickDiv == true) {
           		      operacao = valor / Double.parseDouble(tfVisor.getText());
           		      result = (int) operacao;
         		      if(operacao == result) {
         			     tfVisor.setText(Integer.toString(result));//Mostra o resultado da operação no visor; 
         		      }else{
         			     tfVisor.setText(Double.toString(operacao));//Mostra o resultado da operação no visor
         		      } 
                	  clickDiv = false;
           	    }
                 	 
            }               
        });
		
		
	}	
	/*Classe interna para confinguar o botão ponto;
	Só consegui fazer as operaçãoes com o "."*/
	
	class CInterna implements ActionListener{
		 @Override
			public void actionPerformed(ActionEvent ae) {
				// TODO Auto-generated method stub
			 if(ae.getSource() == btnVir ) { 
				if(tfVisor.getText().indexOf(".")>-1); //Pega o texto o TxtField e verifica se tem ponto;
				else tfVisor.setText(tfVisor.getText() + ".");//Se caso não houver aceita;
			   }			
		   }		 				
	}
		
	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		// TODO Auto-generated method stub
		System.exit(0);//Seta o botão fechar da janela; 
		
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}	

}




	
