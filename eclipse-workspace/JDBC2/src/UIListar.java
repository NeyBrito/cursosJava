import javax.swing.JPanel;
import java.awt.event.ActionListener;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class UIListar extends JPanel {
	
	private JButton btnPrimeiro;
	private JButton btnAnterior;
	private JButton btnProximo;
	private JButton btnUltimo;
	private JButton btnCancelar;
	
	public UIListar() {
		
		btnPrimeiro = new JButton("Primeiro");
		btnPrimeiro.setActionCommand("primeiro");
		add(btnPrimeiro);
		
		btnAnterior = new JButton("Anterior");
		btnAnterior.setActionCommand("anterior");
		add(btnAnterior);
		
		btnProximo = new JButton("Pr\u00F3ximo");
		btnProximo.setActionCommand("próximo");
		add(btnProximo);
		
		btnUltimo = new JButton("\u00DAltimo");
		btnUltimo.setActionCommand("ultimo");
		add(btnUltimo);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setActionCommand("cancelar");
		add(btnCancelar);
	}

	public void addActionListener(ActionListener listener) {
		btnPrimeiro.addActionListener(listener);
		btnAnterior.addActionListener(listener);
		btnProximo.addActionListener(listener);
		btnUltimo.addActionListener(listener);
		btnCancelar.addActionListener(listener);
	}
}
