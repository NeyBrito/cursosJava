import modelo.Usuario;
import persistencia.DAO;

public class AppHibernate {

	public static void main(String[] args) {
		
		// Criando uma inst�ncia de Usu�rio e populando-a com dados.
		// Neste momento, o objeto usr ainda est� num estado transiente,
		// i.e., n�o foi persistido e existe apenas no lado da aplica��o.
		Usuario usr = new Usuario();
		usr.setNome("Sujeito");
		usr.setSobrenome("Desconhecido");
		
		// Usando o nosso DAO, podemos simplesmente informar o objeto para o
		// m�todo adicionar (que tem o c�digo necess�rio para perrsistir um
		// objeto utilizando o Hibernate).
		DAO.adicionar(usr);
		
		// Para nos certificarmos que a informa��o de fato foi armazenada,
		// fa�amos uma consulta utilizando o ID que � autogerado ou pelo
		// nome que sabemos exitir no BD. 
		System.out.println("Consulta por ID = 1:\n\t" + DAO.getUsuarioById(1));		
		System.out.println("Consulta pelo nome = 'Sujeito':\n\t" + DAO.getUsuarioByNome("Sujeito"));
		
		System.exit(0);
	}

}