import modelo.Usuario;
import persistencia.DAO;

public class AppHibernate {

	public static void main(String[] args) {
		
		// Criando uma instância de Usuário e populando-a com dados.
		// Neste momento, o objeto usr ainda está num estado transiente,
		// i.e., não foi persistido e existe apenas no lado da aplicação.
		Usuario usr = new Usuario();
		usr.setNome("Sujeito");
		usr.setSobrenome("Desconhecido");
		
		// Usando o nosso DAO, podemos simplesmente informar o objeto para o
		// método adicionar (que tem o código necessário para perrsistir um
		// objeto utilizando o Hibernate).
		DAO.adicionar(usr);
		
		// Para nos certificarmos que a informação de fato foi armazenada,
		// façamos uma consulta utilizando o ID que é autogerado ou pelo
		// nome que sabemos exitir no BD. 
		System.out.println("Consulta por ID = 1:\n\t" + DAO.getUsuarioById(1));		
		System.out.println("Consulta pelo nome = 'Sujeito':\n\t" + DAO.getUsuarioByNome("Sujeito"));
		
		System.exit(0);
	}

}