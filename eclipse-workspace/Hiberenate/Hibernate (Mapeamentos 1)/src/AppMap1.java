import modelo.Tarefa;
import modelo.Usuario;

import persistencia.DAO;

public class AppMap1 {

	public static void main(String[] args) {

		// Criando uma instância de Tarefa e preenchendo-a com dados.
		Tarefa t = new Tarefa();
		t.setTitulo("Aula ALPOO");
		t.setDescricao("Ensinar como fazer mapeamentos usando o Hibernate.");
		
		// Persistindo a entidade tarefa que criamos
		DAO.salvar(t);
		
		// Recuperando as informações do repositório
		Tarefa task = (Tarefa) DAO.getById(Tarefa.class, 1);
		System.out.println(task);

		// Instanciando um usuário e associando ele a tarefa que havíamos
		// criado inicialmente (não a que foi recuperada durante na consulta
		// anterior).
		Usuario u = new Usuario();
		u.setNome("Leandro");
		u.setSobrenome("Fernandes");
		u.setTarefa(t);
		
		// Persistindo a entidade usuário. Será durante essa operação que o
		// Hibernate criará o vínculo entre as duas instâncias (mapeamento).
		DAO.salvar(u);
		
		// Recuperando as informações do repositório e apresentando os dados
		// na tela. Observe que no método toString da classe Usuario haverá 
		// também uma chamada implícita ao método toString da classe Tarefa.
		Usuario usr = (Usuario) DAO.getById(Usuario.class, 1);
		System.out.println(usr);		
		
		// Por operar no modo "Lazzy fetching", se a session for finalizada
		// antes da recuperação da referência a tarefa do objeto usr ocorrerá
		// uma HibernateException e os dados não poderão ser completamente
		// recuperados do banco. Por isso estamos finalizando a session apenas
		// neste momento.
		DAO.close();
		
		System.exit(0);		
	}

}
