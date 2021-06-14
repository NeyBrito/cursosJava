import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

@SuppressWarnings("serial")
public class UIAgenda extends JFrame {

	public static final int VAZIA = 0;
	public final static int ADICIONAR = 1;
	public final static int LISTAR = 2;

	private JPanel contentPane;

	private UIContato pContatos;
	private UIAdicionar pAdicionar;
	private UIListar pListar;

	private JMenuItem menuAdicionar;
	private JMenuItem menuListar;
	private JMenuItem menuSobre;

	/**
	 * Construtor padr�o.
	 * Cria o conte�do da janela (componentes gr�ficos) que comp�e a interface com o usu�rio.
	 */
	public UIAgenda() {
		setTitle("Agenda de Contatos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		pContatos = new UIContato();
		pAdicionar = new UIAdicionar();
		pListar = new UIListar();

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnContato = new JMenu("Contato");
		menuBar.add(mnContato);

		menuAdicionar = new JMenuItem("Adicionar");
		menuAdicionar.setActionCommand("menuAdicionar");
		mnContato.add(menuAdicionar);

		menuListar = new JMenuItem("Listar");
		menuListar.setActionCommand("menuListar");
		mnContato.add(menuListar);

		JMenu mnOutros = new JMenu("Outros");
		menuBar.add(mnOutros);

		menuSobre = new JMenuItem("Sobre");
		menuSobre.setActionCommand("menuSobre");
		mnOutros.add(menuSobre);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

	public void addActionListener(ActionListener listener) {
		menuAdicionar.addActionListener(listener);
		menuListar.addActionListener(listener);
		menuSobre.addActionListener(listener);

		pAdicionar.addActionListener(listener);
		pListar.addActionListener(listener);
	}

	/**
	 * Configura o conte�do da janela, apresentando os paineis adequados a cada opera��o. 
	 * @param modo valor inteiro que representa a opera��o
	 */
	public void configuraModoDeTela(int modo) {
		contentPane.removeAll();
		switch (modo) {
		case ADICIONAR:
			contentPane.add(pContatos, BorderLayout.CENTER);
			contentPane.add(pAdicionar, BorderLayout.SOUTH);
			break;
		case LISTAR:
			contentPane.add(pContatos, BorderLayout.CENTER);
			contentPane.add(pListar, BorderLayout.SOUTH);
			break;
		}
		contentPane.validate();
		contentPane.repaint();
	}
	
	/**
	 * Apresenta nos componentes gr�ficos as informa��es de um contato
	 * @param c contato a ser exibido
	 */
	public void setContato(Contato c) {
		pContatos.setContato(c);
	}
	
	/**
	 * Recupera as informa��es do contato fornecidas atravv�s da interface
	 * @return uma inst�ncia de Contato com os dados informados
	 */
	public Contato getContato() {
		return pContatos.getContato();
	}
	/**
	 * Limpa os campos de informa��o do painel de contato.
	 */
	
	public void limparCampos() {
		if (pContatos != null) {
			pContatos.limparCampos();
		}
		
	}

}
