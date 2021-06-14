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
	 * Construtor padrão.
	 * Cria o conteúdo da janela (componentes gráficos) que compõe a interface com o usuário.
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
	 * Configura o conteúdo da janela, apresentando os paineis adequados a cada operação. 
	 * @param modo valor inteiro que representa a operação
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
	 * Apresenta nos componentes gráficos as informações de um contato
	 * @param c contato a ser exibido
	 */
	public void setContato(Contato c) {
		pContatos.setContato(c);
	}
	
	/**
	 * Recupera as informações do contato fornecidas atravvés da interface
	 * @return uma instãncia de Contato com os dados informados
	 */
	public Contato getContato() {
		return pContatos.getContato();
	}
	/**
	 * Limpa os campos de informação do painel de contato.
	 */
	
	public void limparCampos() {
		if (pContatos != null) {
			pContatos.limparCampos();
		}
		
	}

}
