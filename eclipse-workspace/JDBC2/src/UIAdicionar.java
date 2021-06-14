import javax.swing.JPanel;

import java.awt.event.ActionListener;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class UIAdicionar extends JPanel {
	
	private JButton btnAdicionar;
	private JButton btnCancelar;
	
	public UIAdicionar() {
		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setActionCommand("adicionar");
		add(btnAdicionar);	
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setActionCommand("cancelar");
		add(btnCancelar);
	}

	public void addActionListener(ActionListener listener) {
		btnAdicionar.addActionListener(listener);
		btnCancelar.addActionListener(listener);
	}
}
