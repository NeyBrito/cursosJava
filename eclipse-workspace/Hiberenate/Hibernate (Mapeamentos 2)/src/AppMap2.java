import modelo.Tarefa;
import modelo.Usuario;

import persistencia.DAO;

public class AppMap2 {

	public static void main(String[] args) {

		// Instanciando um usu�rio e associando ele uma lista de tarefas que
		// criaremos logo a seguir.
		Usuario usr = new Usuario();
		usr.setNome("Leandro");
		usr.setSobrenome("Fernandes");
		
		// Criando v�rias tarefas relacionadas ao nosso usu�rio.
		Tarefa t1 = new Tarefa();
		t1.setTitulo("Aula Hibernate");
		t1.setDescricao("Ensinar como realizar persist�ncia usando o Hibernate.");

		usr.addTarefa(t1);
		
		Tarefa t2 = new Tarefa();
		t2.setTitulo("Aula Mapeamentos");
		t2.setDescricao("Como criar mapeamentos usando o Hibernate para representar relacionamentos entre classes.");
		
		usr.addTarefa(t2);
		
		// Persistindo a entidade usu�rio. Ser� durante essa opera��o que o
		// Hibernate criar� o v�nculo entre as duas inst�ncias (mapeamento).
		DAO.salvar(usr);

		// Embora haja um objeto Session ativo, decorrente da primeira chamada
		// ao m�todo salvar, deixei aqui uma instru��o clara para que voc� se
		// lembre que � necess�rio trabalhar com objetos no estado "persistente"
		// quando operamos com entidades que est�o relacionadas.
		// Isso ocorre porque o Hibernate posterga a consulta das informa��es
		// relacionadas, realizando-a apenas quando os dados s�o requisitados.
		DAO.getSession();

		// Recuperando as informa��es do reposit�rio e apresentando os dados
		// na tela. Observe que no m�todo toString da classe Usuario haver� 
		// tamb�m v�rias chamadas ao m�todo toString da classe Tarefa, uma
		// para cada tarefa que exista na lista deste usu�rio.
		Usuario usuario = (Usuario) DAO.getById(Usuario.class, 1);
		System.out.println(usuario);		
		
		// Lembre-se que no modo "Lazzy fetching", se a Session for finalizada
		// antes da recupera��o da lista de tarefas deste usu�rio os dados n�o
		// poder�o ser recuperados do reposit�rio, gerando assim uma Exception.
		DAO.close();
		
		System.exit(0);
	}

}
