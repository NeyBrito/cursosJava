package JavaANT;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UIComponentesAWT extends Frame implements ActionListener {
	/*Declara��o de Componentes*/
	
	private Label lblNome,lblGenero, lblMsg;
	private TextField tfNome;
	private Checkbox cbMasc, cbFem;
	private CheckboxGroup cbgrpGenero;
	private TextArea txtMsg;
	private Choice chCidade;
	private Button btnEnviar;
	
    public UIComponentesAWT() {
    	/*Instancia��o*/
    	lblNome = new Label("Nome:");
    	lblGenero = new Label("Genero:");
    	lblMsg = new Label("Mensagem:");
    	tfNome = new TextField();
    	cbgrpGenero = new CheckboxGroup();
     	cbMasc = new Checkbox("Masculino", false, cbgrpGenero);
     	cbFem = new Checkbox("Feminino", false, cbgrpGenero);  	
    	txtMsg = new TextArea();
    	chCidade = new Choice();
    	btnEnviar = new Button("Enviar");
    	
    	/*Posicionamento*/
    	lblNome.setBounds(20,50,60,20);
    	tfNome.setBounds(90,50,180,20);
    	lblGenero.setBounds(20,75,60,20);
    	lblMsg.setBounds(20,110,80,20);
    	cbMasc.setBounds(90,75,180,20);
    	cbFem.setBounds(90,95,180,20);    	
    	txtMsg.setBounds(20,130,250,150);
    	chCidade.setBounds(20,300,250,20);
    	btnEnviar.setBounds(190,340,80,20);
    	
    	/*prp.relacionadas a janela*/
    	this.setTitle("Componentes AWT");
    	this.setSize(300,380);
    	this.setLayout(null);
    	
    	/*Adionando componentes ao Container*/
    	this.add(lblNome);
    	this.add(tfNome);
    	this.add(lblGenero);
    	this.add(lblMsg);
    	this.add(cbMasc);
    	this.add(cbFem);
      	this.add(chCidade);
    	this.add(btnEnviar);
    	this.add(txtMsg);    	
    	chCidade.add("Rinc�o");
    	chCidade.add("Rio Claro");
    	chCidade.add("Araraquara");
    	chCidade.add("S�o Carlos");
    	chCidade.add("Ribeir�o Preto");
    	
    	/* Tratar eventos*/
//    	btnEnviar.addActionListener();
    	 btnEnviar.addActionListener(
   			  new ActionListener(){
   				  @Override
   				  public void actionPerformed(ActionEvent ex) {
   					  System.out.println(tfNome);
   					  System.out.println(chCidade);
   					  System.out.println(cbgrpGenero);
   					  System.out.println(txtMsg);
   					  System.exit(0);
   					  					  
   				  }					
   				
   			  });    	
    	
    }

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

   
}
