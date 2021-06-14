import modelo.Tarefa;
import modelo.Usuario;

import persistencia.DAO;

public class AppMap2 {

	public static void main(String[] args) {

		// Instanciando um usuário e associando ele uma lista de tarefas que
		// criaremos logo a seguir.
		Usuario usr = new Usuario();
		usr.setNome("Leandro");
		usr.setSobrenome("Fernandes");
		
		// Criando várias tarefas relacionadas ao nosso usuário.
		Tarefa t1 = new Tarefa();
		t1.setTitulo("Aula Hibernate");
		t1.setDescricao("Ensinar como realizar persistência usando o Hibernate.");

		usr.addTarefa(t1);
		
		Tarefa t2 = new Tarefa();
		t2.setTitulo("Aula Mapeamentos");
		t2.setDescricao("Como criar mapeamentos usando o Hibernate para representar relacionamentos entre classes.");
		
		usr.addTarefa(t2);
		
		// Persistindo a entidade usuário. Será durante essa operação que o
		// Hibernate criará o vínculo entre as duas instâncias (mapeamento).
		DAO.salvar(usr);

		// Embora haja um objeto Session ativo, decorrente da primeira chamada
		// ao método salvar, deixei aqui uma instrução clara para que você se
		// lembre que é necessário trabalhar com objetos no estado "persistente"
		// quando operamos com entidades que estão relacionadas.
		// Isso ocorre porque o Hibernate posterga a consulta das informações
		// relacionadas, realizando-a apenas quando os dados são requisitados.
		DAO.getSession();

		// Recuperando as informações do repositório e apresentando os dados
		// na tela. Observe que no método toString da classe Usuario haverá 
		// também várias chamadas ao método toString da classe Tarefa, uma
		// para cada tarefa que exista na lista deste usuário.
		Usuario usuario = (Usuario) DAO.getById(Usuario.class, 1);
		System.out.println(usuario);		
		
		// Lembre-se que no modo "Lazzy fetching", se a Session for finalizada
		// antes da recuperação da lista de tarefas deste usuário os dados não
		// poderão ser recuperados do repositório, gerando assim uma Exception.
		DAO.close();
		
		System.exit(0);
	}

}
