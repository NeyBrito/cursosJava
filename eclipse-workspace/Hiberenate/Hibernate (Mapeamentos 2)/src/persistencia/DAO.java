package persistencia;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import modelo.Tarefa;
import modelo.Usuario;
import persistencia.hibernate.HibernateUtil;

/**
 * Classe que implementa o padr�o DAO (Data Access Object) respons�vel por
 * realizar as opera��es relativas a persist�nciade dados.
 * 
 * @author Leandro Fernandes
 *
 */
public class DAO {

	/**
	 * Armazena a refer�ncia de Session num objeto ThreadLocal permitindo
	 * compartilh�-lo com quaisquer outros threads da aplica��o.
	 */
	private static final ThreadLocal<Session> session = new ThreadLocal<Session>();

	/**
	 * Recupera uma se��o para transacionar com o reposit�rio de dados.
	 * @return uma inst�ncia de org.hibernate.Session.
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
	 * Cria um marcador de in�cio de transa��o.
	 */
	protected static void begin() {
		getSession().beginTransaction();
	}

	/**
	 * Grava as altera��es realizadas durante a transa��o.
	 */
	protected static void commit() {
		getSession().getTransaction().commit();
	}

	/**
	 * Descarta as altera��es realizadas durante a transa��o.
	 */
	protected static void rollback() {
		try {
			getSession().getTransaction().rollback();
		} catch (HibernateException e) {
			System.out.println("N�o foi poss�vel fazer rollback da transa��o");
		}

		try {
			getSession().close();
		} catch (HibernateException e) {
			System.out.println("N�o foi poss�vel fazer fechar a sess�o");
		}

		DAO.session.set(null);
	}

	/**
	 * Encerrar a se��o com o reposit�rio.
	 */
	public static void close() {
		getSession().close();
		DAO.session.set(null);
	}

	/**
	 * Consulta o reposit�rio, retornando a entidade que tem ID igual ao par�metro informado 
	 * @param classe tipo da entidade a ser pesquisada
	 * @param id valor identificador
	 * @return retorna uma inst�ncia da classe informada; ou null, caso n�o encontrado.
	 */
	public static Object getById(Class<?> classe, int id) {
		Object objeto = null;
		objeto = getSession().get(classe, id);
		return objeto;
	}

	/**
	 * Persiste uma entidade da classe Usuario no reposit�rio.
	 * @param usr entidade a ser gravada no reposit�rio.
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
