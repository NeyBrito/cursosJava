import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 * Classe que atua como intermediária para o acesso aos dados e a aplicação
 * @author Leandro Fernandes
 */
public class DAO {

	public static void adicionar(Usuario usuario) {
		Transaction trns = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			trns = session.beginTransaction();
			session.save(usuario);
			session.getTransaction().commit();
		}
		catch (RuntimeException e) {
			if (trns != null) trns.rollback();
			e.printStackTrace();
		}
		finally {
			session.close();
		}
	}
	
	public static void adicionar(Tarefa tarefa) {
		Transaction trns = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			trns = session.beginTransaction();
			session.save(tarefa);
			session.getTransaction().commit();
		}
		catch (RuntimeException e) {
			if (trns != null) trns.rollback();
			e.printStackTrace();
		}
		finally {
			session.close();
		}
	}

	public static void atualizar(Usuario usuario) {
		Transaction trns = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			trns = session.beginTransaction();
			session.update(usuario);
			session.getTransaction().commit();
		}
		catch (RuntimeException e) {
			if (trns != null) trns.rollback();
			e.printStackTrace();
		}
		finally {
			session.close();
		}
	}
	
	public static void remover(Usuario user) {
		Transaction trns = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			trns = session.beginTransaction();
			session.delete(user);
			session.getTransaction().commit();
		}
		catch (RuntimeException e) {
			if (trns != null) trns.rollback();
			e.printStackTrace();
		}
		finally {
			session.close();
		}
	}

	public static int atualizarSobrenome(int id, String sobrenome) {
		int qtdeRegAtualizados = 0;
		Transaction trns = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			trns = session.beginTransaction();
			String hqlUpdate = "update Usuario u set u.sobrenome = :novoSobrenome where u.id = :codigoId";
			qtdeRegAtualizados = session.createQuery(hqlUpdate)
					.setString("novoSobrenome", sobrenome)
					.setInteger("codigoId", id)
					.executeUpdate();
			trns.commit();
		}
		catch (RuntimeException e) {
			if (trns != null) trns.rollback();
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		return qtdeRegAtualizados;
	}

	public static String getNomeCompleto(String primeiroNome) {
		String nomeCompleto = "";
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			@SuppressWarnings("unchecked")
			Query query = session.createQuery("from Usuario as u where u.nome = :firstName");
			List<Usuario> users = query.setString("firstName", primeiroNome).list();
			if (!users.isEmpty()) {
				Usuario user = users.get(0);
				nomeCompleto = user.getNome() + " " + user.getSobrenome();
			}
		}
		catch (RuntimeException e) {
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		return nomeCompleto;
	}

	public static List<Tarefa> getListaDeTarefas(Usuario usr) {
		List<Tarefa> lstTarefas = null;
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			String hqlUpdate = "from Tarefa t where t.usrId = :codigoId";
			lstTarefas = session.createQuery(hqlUpdate)
					.setInteger("codigoId", usr.getId())
					.getResultList();
		}
		catch (RuntimeException e) {
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		
		return lstTarefas;
	}
}
