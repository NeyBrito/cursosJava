package br.unip.cc.bnmc; 
import javax.swing.JFrame; 
import javax.swing.JPanel; 
import javax.swing.border.EmptyBorder; 
import javax.swing.JLabel; 
import javax.swing.JButton; 
import java.awt.event.ActionListener; 
import java.awt.event.ActionEvent; 
import java.awt.Font; 
import java.awt.Color; 
import java.awt.Toolkit; 

@SuppressWarnings("serial") 
public class JSobreFrame extends JFrame { 
	private JPanel contentPane; 
	private JLabel lblEquipe; 
	private JLabel lblNey; 
	private JLabel lblEdiney; 
	 
	private JButton btnVoltar; 
	public JSobreFrame() { 
		setIconImage(Toolkit.getDefaultToolkit().getImage(JSobreFrame.class.getResource("/com/sun/java/swing/plaf/windows/icons/DetailsView.gif")));
	
	setType(Type.UTILITY);
	JMenuFrame.sobreVisible = true; 
	setTitle("Equipe de Desenvolvimento"); 
	setVisible(true); setResizable(false); 
	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
	setBounds(100, 100, 450, 272); 
	contentPane = new JPanel(); 
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5)); 
	setContentPane(contentPane); 
	contentPane.setLayout(null);
	lblEquipe = new JLabel("DESENVOLVEDORES"); 
	lblEquipe.setForeground(Color.RED); 
	lblEquipe.setFont(new Font("Arial", Font.BOLD, 14)); 
	lblEquipe.setBounds(148, 11, 152, 20); 
	contentPane.add(lblEquipe); 
	lblNey = new JLabel("Ney Marcos Lopes de Brito"); 
	lblNey.setFont(new Font("Arial", Font.BOLD, 14)); 
	lblNey.setBounds(123, 42, 232, 33); 
	contentPane.add(lblNey); 
	lblEdiney = new JLabel("Edinei Valdecir Valter"); 
	lblEdiney.setFont(new Font("Arial", Font.BOLD, 14)); 
	lblEdiney.setBounds(123, 71, 232, 33); 
	contentPane.add(lblEdiney);  
	btnVoltar = new JButton("VOLTAR"); 
	btnVoltar.setForeground(Color.BLUE); 
	btnVoltar.setFont(new Font("Arial", Font.BOLD, 14)); 
	btnVoltar.setBounds(162, 173, 116, 46); 
	contentPane.add(btnVoltar);
	btnVoltar.addActionListener(new ActionListener() {		 
	      public void actionPerformed(ActionEvent arg0) { 
		JMenuFrame.sobreVisible = false; setVisible(false); 
		} 
	}); 
  } 
} 