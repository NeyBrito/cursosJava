package modelo;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.healthmarketscience.jackcess.query.Query;

import persistencia.HibernateUtil;

public class DAO {
	
	public static void adicionar(Usuario usr){
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction trns;
		try{
			trns = s.beginTransaction();
			s.save(usr);
			trns.commit();
		}
		catch (Exception e ){
			System.out.println("Algo deu errado : "+e.getMessage());
		}finally{
			s.close();
		}
	}
	
	public static void adicionar(Tarefa trf){
		Session s = HibernateUtil.getSessionFactory().openSession();
		try{
			s.beginTransaction();
			s.save(trf);
			s.getTransaction().commit();
		}
		catch (Exception e ){
			System.out.println("Algo deu errado : "+e.getMessage());
		}finally{
			s.close();
		}
	}
	
	public static void atualizar(Usuario usr){
		Session s = HibernateUtil.getSessionFactory().openSession();
		try{
			s.beginTransaction();
			s.update(usr);
			s.getTransaction().commit();
		}
		catch (Exception e ){
			System.out.println("Algo deu errado : "+e.getMessage());
		}finally{
			s.close();
		}
	}
	
	public static void remover(Usuario usr){
		Transaction trns = null;
		Session s = HibernateUtil.getSessionFactory().openSession();
		try{
			trns= s.beginTransaction();
			s.delete(usr);
			trns.commit();
		}
		catch (Exception e ){
			if(trns != null)trns.rollback();
			System.out.println("Algo deu errado : "+e.getMessage());
		}finally{
			s.close();
		}
	}
	
	public static void atualizarSobrenome(int id, String Sobrenome){
		Usuario usr = null;
		Session s = HibernateUtil.getSessionFactory().openSession();
		try{
			 usr = s.get(Usuario.class, new Integer(id));
			 usr.setSobrenome(Sobrenome);
			 s.update(usr);
			 s.getTransaction().commit();
			 
		}catch (Exception e ){
			System.out.println("Algo deu errado : "+e.getMessage());
		}finally{
			s.close();
		}
	}
	
	public static String getNomeCompleto(String nome){
		String nomeCompleto = null;
		Session s =  HibernateUtil.getSessionFactory().openSession();
		try {
			Query query = (Query) s.createQuery("from Usuario as u where u.nome= :prim_nome");
			List<Usuario> lstUser = ((org.hibernate.query.Query) query).setString("prim_nome", nome).list();
			Usuario usr = lstUser.get(0);
			nomeCompleto= usr.getNome()+ " " + usr.getSobrenome();
 			
		}catch(RuntimeException e){
			
		}finally{
			s.close();
		}
		return nomeCompleto;
	}
	
	public static List<Tarefa> getLstTarefas(List<Tarefa> Usuario){
		return Usuario;
	}
	
	public Usuario getUsuario(int id){
		Usuario usr = null;
		Session s = HibernateUtil.getSessionFactory().openSession();
		try{
			usr = s.get(Usuario.class,new Integer(id));
		}catch( Exception e){
			
		}finally{
			s.close();
		}
		return usr;
		
	}
}


// get retorna null se nao achar e se achar retorna... load gera exceção caso não ache.