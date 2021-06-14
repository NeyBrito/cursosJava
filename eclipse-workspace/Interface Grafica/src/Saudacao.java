import java.awt.Frame;
import java.awt.Label;
import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; 

 public class Saudacao extends Frame{
	 private Label msg;
	 private Button btnOk;
	 private Label Ola;
	 
	 public Saudacao(){
	  msg=new Label();
	  msg.setText("Olá Mundo Gráfico");
	  msg.setBounds(20,40,160,20);
	  
	  Ola=new Label();
	  Ola.setText("Toca ai!");
	  Ola.setBounds(30,50,170,30);
	  Ola.setVisible(false);
	  
	  btnOk = new Button();
	  btnOk.setLabel("Ok");
	  btnOk.setBounds(110,80,80,20);
	  btnOk.addActionListener(
			  new ActionListener(){
				  @Override
				  public void actionPerformed(ActionEvent ex) {
					  System.exit(0);;
					  
				  }					
				
			  });
	  
	  this.setLayout(null);
	  this.add(msg);
	  this.add(btnOk);
	  this.add(Ola);
	  this.setTitle("Olá Gui");
	  this.setSize(300,200);
	 }
	 public void setMensagem(String Texto){
		  msg.setText("Olá. Clique em "+ "OK" + " para sair");
		}


}
