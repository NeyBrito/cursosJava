import java.util.*;
import org.hibernate.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import modelo.Usuario;

/**
 * Exemplo de uso do Hibernate.
 * Este programa contém as etapas básicas para configura e inicializar o Hibernate,
 * deixando-o pronto para operar com uma base de dados. Para efeitos de exemplo, uma
 * consulta é realizada procurando por um usuário cujo código seja igual a 1.
 * 
 * @author Leandro Fernandes
 */
public class TesteSimples {
	
	public static void main(String[] args) {
		
		// Criando um objeto de configuração para o Hibernate
		Configuration cfg = new Configuration();
		// Carregando a configuração a partir do arquivo identificado
		cfg.configure("hib.cfg.xml");
		
		// Cria uma fábrica de sessões 
		SessionFactory factory = cfg.buildSessionFactory();
		
		// Obtem uma sessão para executar as operações
		Session session = factory.openSession();
		
		// Fazer uma consulta procurando pelo usuário com código 1
		Usuario usr = session.get(Usuario.class, new Integer(1));		
		if (usr != null)
			System.out.println(usr.getNome() + " " + usr.getSobrenome());
		else
			System.out.println("Usuário não encontrado.");

		// Encerra a sessão
		session.close();
		
		// Fecha a fábrica
		factory.close();
		
		// .. e termina o programa
		System.exit(0);
	}

}
