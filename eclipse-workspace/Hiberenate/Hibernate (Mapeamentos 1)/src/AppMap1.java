import modelo.Tarefa;
import modelo.Usuario;

import persistencia.DAO;

public class AppMap1 {

	public static void main(String[] args) {

		// Criando uma inst�ncia de Tarefa e preenchendo-a com dados.
		Tarefa t = new Tarefa();
		t.setTitulo("Aula ALPOO");
		t.setDescricao("Ensinar como fazer mapeamentos usando o Hibernate.");
		
		// Persistindo a entidade tarefa que criamos
		DAO.salvar(t);
		
		// Recuperando as informa��es do reposit�rio
		Tarefa task = (Tarefa) DAO.getById(Tarefa.class, 1);
		System.out.println(task);

		// Instanciando um usu�rio e associando ele a tarefa que hav�amos
		// criado inicialmente (n�o a que foi recuperada durante na consulta
		// anterior).
		Usuario u = new Usuario();
		u.setNome("Leandro");
		u.setSobrenome("Fernandes");
		u.setTarefa(t);
		
		// Persistindo a entidade usu�rio. Ser� durante essa opera��o que o
		// Hibernate criar� o v�nculo entre as duas inst�ncias (mapeamento).
		DAO.salvar(u);
		
		// Recuperando as informa��es do reposit�rio e apresentando os dados
		// na tela. Observe que no m�todo toString da classe Usuario haver� 
		// tamb�m uma chamada impl�cita ao m�todo toString da classe Tarefa.
		Usuario usr = (Usuario) DAO.getById(Usuario.class, 1);
		System.out.println(usr);		
		
		// Por operar no modo "Lazzy fetching", se a session for finalizada
		// antes da recupera��o da refer�ncia a tarefa do objeto usr ocorrer�
		// uma HibernateException e os dados n�o poder�o ser completamente
		// recuperados do banco. Por isso estamos finalizando a session apenas
		// neste momento.
		DAO.close();
		
		System.exit(0);		
	}

}
