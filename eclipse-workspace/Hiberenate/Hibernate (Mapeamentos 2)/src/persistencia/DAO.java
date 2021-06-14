package persistencia;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import modelo.Tarefa;
import modelo.Usuario;
import persistencia.hibernate.HibernateUtil;

/**
 * Classe que implementa o padrão DAO (Data Access Object) responsável por
 * realizar as operações relativas a persistênciade dados.
 * 
 * @author Leandro Fernandes
 *
 */
public class DAO {

	/**
	 * Armazena a referência de Session num objeto ThreadLocal permitindo
	 * compartilhá-lo com quaisquer outros threads da aplicação.
	 */
	private static final ThreadLocal<Session> session = new ThreadLocal<Session>();

	/**
	 * Recupera uma seção para transacionar com o repositório de dados.
	 * @return uma instância de org.hibernate.Session.
	 */
	public static Session getSession() {
		Session s = DAO.session.get();
		if (s == null) {
			s = HibernateUtil.getSessionFactory().openSession();
			DAO.session.set(s);
		}
		return s;
	}

	/**
	 * Cria um marcador de início de transação.
	 */
	protected static void begin() {
		getSession().beginTransaction();
	}

	/**
	 * Grava as alterações realizadas durante a transação.
	 */
	protected static void commit() {
		getSession().getTransaction().commit();
	}

	/**
	 * Descarta as alterações realizadas durante a transação.
	 */
	protected static void rollback() {
		try {
			getSession().getTransaction().rollback();
		} catch (HibernateException e) {
			System.out.println("Não foi possível fazer rollback da transação");
		}

		try {
			getSession().close();
		} catch (HibernateException e) {
			System.out.println("Não foi possível fazer fechar a sessão");
		}

		DAO.session.set(null);
	}

	/**
	 * Encerrar a seção com o repositório.
	 */
	public static void close() {
		getSession().close();
		DAO.session.set(null);
	}

	/**
	 * Consulta o repositório, retornando a entidade que tem ID igual ao parâmetro informado 
	 * @param classe tipo da entidade a ser pesquisada
	 * @param id valor identificador
	 * @return retorna uma instância da classe informada; ou null, caso não encontrado.
	 */
	public static Object getById(Class<?> classe, int id) {
		Object objeto = null;
		objeto = getSession().get(classe, id);
		return objeto;
	}

	/**
	 * Persiste uma entidade da classe Usuario no repositório.
	 * @param usr entidade a ser gravada no repositório.
	 */
	public static void salvar(Usuario usr) {
		try {
			begin();			
			getSession().save(usr);
			for (Tarefa task : usr.getListaDeTarefas()) {
				getSession().save(task);
			}
			commit();
		} catch (RuntimeException e) {
			rollback();
		}
	}
	
}
