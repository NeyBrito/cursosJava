import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class GerenciadorDaAgenda implements ActionListener {

	private UIAgenda gui;
	private BD banco;

	/**
	 * Construtor padrão. Responsável por isntanciar cada um dos módulos.
	 */
	public GerenciadorDaAgenda() {
		gui = new UIAgenda();
		gui.addActionListener(this);
		banco = new BD();
	}

	/**
	 * Inicia a aplicação
	 */
	public void iniciar() {
		gui.setSize(500, 250);
		gui.setVisible(true);
		banco.conectar();
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		int cursor;
		// Eventos ligados as opções dos menus
		if (ae.getActionCommand().equals("menuAdicionar")) {
			gui.configuraModoDeTela(UIAgenda.ADICIONAR);
		} else if (ae.getActionCommand().equals("menuListar")) {
			cursor = 0;
			gui.setContato(lstContatos.get(cursor));
			
		} else if (ae.getActionCommand().equals("menuSobre")) {
			JOptionPane.showMessageDialog(gui, 
					"Esta aplicação foi desenvolvida durante as aulas de ALPOO."
			         , "Agenda contatos", JOptionPane.PLAIN_MESSAGE);
		}
		// Eventos ligados aos botões da interface gráfica
		else if (ae.getActionCommand().equals("adicionar")) {
			Contato c = gui.getContato();			
			if (banco.inserir(c)) {
				JOptionPane.showMessageDialog(gui, "Contato adicionado com sucesso!",
				 "Inserir", JOptionPane.INFORMATION_MESSAGE);
				gui.limparCampos();
			}		
			else {
				JOptionPane.showMessageDialog(gui, "Algo errado aconteceu. \n contato não adicionado!",
						 "Inserir", JOptionPane.ERROR_MESSAGE);
			}
		} else if (ae.getActionCommand().equals("primeiro")) {
			cursor++;
			Object lstContatos;
			gui.setContato(lstContatos.get(cursor));
			
		} else if (ae.getActionCommand().equals("anterior")) {
			if(cursor > 0) {
				cursor--;
				Object lstContatos;
				gui.setContato(lstContatos.get(cursor));				
			}			
		
		} else if (ae.getActionCommand().equals("próximo")) {
			// TODO: Implementar a recuperação do próximo registro no BD
		} else if (ae.getActionCommand().equals("último")) {
			// TODO: Implementar a operação de último registro no BD
		} else if (ae.getActionCommand().equals("cancelar")) {
			gui.configuraModoDeTela(UIAgenda.VAZIA);
		}

	}

}
