import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class UIContato extends JPanel {
	
	private JTextField tfNome;
	private JTextField tfTelefone;
	private JTextField tfEmail;

	/**
	 * Create the panel.
	 */
	public UIContato() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNome = new JLabel("Nome");
		GridBagConstraints gbc_lblNome = new GridBagConstraints();
		gbc_lblNome.anchor = GridBagConstraints.EAST;
		gbc_lblNome.insets = new Insets(0, 0, 5, 5);
		gbc_lblNome.gridx = 1;
		gbc_lblNome.gridy = 1;
		add(lblNome, gbc_lblNome);
		
		tfNome = new JTextField();
		GridBagConstraints gbc_tfNome = new GridBagConstraints();
		gbc_tfNome.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfNome.insets = new Insets(0, 0, 5, 5);
		gbc_tfNome.gridx = 2;
		gbc_tfNome.gridy = 1;
		add(tfNome, gbc_tfNome);
		tfNome.setColumns(10);
		
		JLabel lblTelefone = new JLabel("Telefone");
		GridBagConstraints gbc_lblTelefone = new GridBagConstraints();
		gbc_lblTelefone.anchor = GridBagConstraints.EAST;
		gbc_lblTelefone.insets = new Insets(0, 0, 5, 5);
		gbc_lblTelefone.gridx = 1;
		gbc_lblTelefone.gridy = 2;
		add(lblTelefone, gbc_lblTelefone);
		
		tfTelefone = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 2;
		gbc_textField_1.gridy = 2;
		add(tfTelefone, gbc_textField_1);
		tfTelefone.setColumns(10);
		
		JLabel lblEmail = new JLabel("E-mail");
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.anchor = GridBagConstraints.EAST;
		gbc_lblEmail.insets = new Insets(0, 0, 0, 5);
		gbc_lblEmail.gridx = 1;
		gbc_lblEmail.gridy = 3;
		add(lblEmail, gbc_lblEmail);
		
		tfEmail = new JTextField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 0, 5);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 2;
		gbc_textField_2.gridy = 3;
		add(tfEmail, gbc_textField_2);
		tfEmail.setColumns(10);

	}

	public void setContato(Contato c) {
		tfNome.setText( c.getNome() );
		tfTelefone.setText( c.getTelefone() );
		tfEmail.setText( c.getEmail() );
	}
	
	public Contato getContato() {
		Contato c = new Contato();
		c.setNome( tfNome.getText() );
		c.setTelefone( tfTelefone.getText() );
		c.setEmail( tfEmail.getText() );
		return c;
	}

	public void limparCampos() {
		tfNome.setText("");
		tfTelefone.setText("");
		tfEmail.setText("");
		tfNome.grabFocus(); //Deixa o cursor no campo nome.
	}
}
