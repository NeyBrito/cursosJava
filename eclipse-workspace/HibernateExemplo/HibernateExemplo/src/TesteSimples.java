import java.util.*;
import org.hibernate.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import modelo.Usuario;

/**
 * Exemplo de uso do Hibernate.
 * Este programa cont�m as etapas b�sicas para configura e inicializar o Hibernate,
 * deixando-o pronto para operar com uma base de dados. Para efeitos de exemplo, uma
 * consulta � realizada procurando por um usu�rio cujo c�digo seja igual a 1.
 * 
 * @author Leandro Fernandes
 */
public class TesteSimples {
	
	public static void main(String[] args) {
		
		// Criando um objeto de configura��o para o Hibernate
		Configuration cfg = new Configuration();
		// Carregando a configura��o a partir do arquivo identificado
		cfg.configure("hib.cfg.xml");
		
		// Cria uma f�brica de sess�es 
		SessionFactory factory = cfg.buildSessionFactory();
		
		// Obtem uma sess�o para executar as opera��es
		Session session = factory.openSession();
		
		// Fazer uma consulta procurando pelo usu�rio com c�digo 1
		Usuario usr = session.get(Usuario.class, new Integer(1));		
		if (usr != null)
			System.out.println(usr.getNome() + " " + usr.getSobrenome());
		else
			System.out.println("Usu�rio n�o encontrado.");

		// Encerra a sess�o
		session.close();
		
		// Fecha a f�brica
		factory.close();
		
		// .. e termina o programa
		System.exit(0);
	}

}
