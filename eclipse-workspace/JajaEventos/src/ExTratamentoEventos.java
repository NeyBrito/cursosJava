import java.awt.*;
import java.awt.event.*;

public class ExTratamentoEventos extends Frame implements WindowListener{
	private Button btn1,btn2,btn3;
	
	/*Construtor*/
	public ExTratamentoEventos() {
		//instanciando componentes
		btn1 = new Button("Botão 1");
		btn2 = new Button("Botão 2");
		btn3 = new Button("Botão 3");
		
		//Definindo suas propriedades
		btn1.setActionCommand("Ação 1");
		btn2.setActionCommand("Ação 2");
		btn3.setActionCommand("Ação 3");
		
		//posicionando container
	    this.setLayout(new FlowLayout());
	    this.add(btn1);
	    this.add(btn2);
	    this.add(btn3);
	    
	    this.setSize(320, 150);
	    
	    //tratando eventos
	    //1) classe anônima
	    btn1.addActionListener(
				  new ActionListener(){
					  @Override
					  public void actionPerformed(ActionEvent ae) {
						  System.out.println("Click no botão 1");
						  
					  }					
					
				  });
	    
	    this.addWindowListener(this);
	    //2)Inner Class
	    CInterna objInner = new CInterna();
	    btn2.addActionListener(objInner);
	    
	    //3)Outside Class
	    CExterna objExt = new CExterna();
	    btn3.addActionListener(objExt);
	    
	   
	}
	
	 class CInterna implements ActionListener{
		 @Override
			public void actionPerformed(ActionEvent ae) {
				// TODO Auto-generated method stub
				if(ae.getSource() == btn2 );
				System.out.println("Clicke no botão 2");
				
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
	public void windowClosing(WindowEvent we) {
		// TODO Auto-generated method stub
		System.exit(0);
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
