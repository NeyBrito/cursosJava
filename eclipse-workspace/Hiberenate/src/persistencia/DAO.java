package persistencia;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import modelo.Usuario;

/**
 * Classe intermedi�ria provendo a troca de objetos entre a aplica��o e o BD.
 *  
 * @author Leandro Fernandes
 */
public class DAO {

	/**
	 * Consulta e retorna um Usu�rio de acordo com o valor de campo identificador
	 * 
	 * @param id valor para o atributo ID
	 * @return uma inst�ncia de usu�rio ou null caso n�o encontrado.
	 */
	public static Usuario getUsuarioById(int id) {
		Usuario usr = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			usr = session.get(Usuario.class, id);
		} catch (Exception e) {
			System.err.println("Ops! Erro: " + e.getMessage());
		} finally {
			session.close();
		}
		return usr;
	}

	/**
	 * Consulta e retorna um Usu�rio pesquisando pelo seu nome.
	 * 
	 * @param primeiroNome String correspondente ao nome a ser pesquisado.
	 * @return uma inst�ncia de usu�rio ou null caso n�o encontrado.
	 */
	public static Usuario getUsuarioByNome(String primeiroNome) {
		Usuario usr = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			Query<Usuario> query = session.createQuery("from Usuario as u where u.nome = :firstName", Usuario.class);
			List<Usuario> lstUsuarios = query.setParameter("firstName", primeiroNome).list();
			if (!lstUsuarios.isEmpty())
				usr = lstUsuarios.get(0);
		} catch (RuntimeException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return usr;
	}

	/**
	 * Adiciona um objeto Usu�rio na base de dados.
	 * 
	 * @param usuario objeto a ser persistido.
	 */
	public static void adicionar(Usuario usuario) {
		Transaction trns = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			trns = session.beginTransaction();
			session.save(usuario);
			trns.commit();
		} catch (RuntimeException e) {
			if (trns != null)
				trns.rollback();
			e.printStackTrace();
		} finally {
			// session.flush();
			session.close();
		}
	}

	/**
	 * Atualiza as informa��es de um objeto Usu�rio na base de dados.
	 * 
	 * @param usuario objeto a ser atualizado.
	 */
	public static void atualizar(Usuario usuario) {
		Transaction trns = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			trns = session.beginTransaction();
			session.update(usuario);
			trns.commit();
		} catch (RuntimeException e) {
			if (trns != null)
				trns.rollback();
			e.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}
	}

	/**
	 * Remove um objeto da base de dados.
	 * 
	 * @param usuario objeto a ser removido.
	 */
	public static void remover(Usuario usuario) {
		Transaction trns = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			trns = session.beginTransaction();
			session.delete(usuario);
			session.getTransaction().commit();
		} catch (RuntimeException e) {
			if (trns != null)
				trns.rollback();
			e.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}
	}

	/**
	 * Atualiza as informa��es relativas ao atributo sobrenome de uma inst�ncia da
	 * classe Usu�rio na base de dados.
	 * 
	 * @param id        valor de identifica��o do usu�rio
	 * @param sobrenome novo valor para o atributo sobrenome.
	 * @return quantidade de registros modificados durante a opera��o.
	 */
	public static int atualizarSobrenome(int id, String sobrenome) {
		int qtdeRegAtualizados = 0;
		Transaction trns = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			trns = session.beginTransaction();
			String hqlUpdate = "update Usuario u set u.sobrenome = :novoSobrenome where u.id = :codigoId";
			qtdeRegAtualizados = session.createQuery(hqlUpdate)
					.setParameter("novoSobrenome", sobrenome)
					.setParameter("codigoId", id)
					.executeUpdate();
			trns.commit();
		} catch (RuntimeException e) {
			if (trns != null)
				trns.rollback();
			e.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}
		return qtdeRegAtualizados;
	}

}