package persistencia;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

		private static SessionFactory fabrica = null;

		
		private HibernateUtil() {
			try{
			Configuration cfg = new Configuration();
			cfg.configure("hib.cfg.xml");
			fabrica = cfg.buildSessionFactory();
			}
			catch(Throwable e ) {
				System.out.println("Publrema: "+e.getMessage());
			}
		} 
		
		public static SessionFactory getSessionFactory(){
			if (fabrica == null) {
				new HibernateUtil();}
			return fabrica;
		}
		
		@SuppressWarnings("deprecation")
		public void finalize() {
			try {
			fabrica.close();
			super.finalize();
			}
			catch(Throwable e) {
				System.out.println("Publrema: "+e.getMessage());
			}
		}
		// TO_DO Criar classe DAO, com metodos publicos addUsuario(Usuario persistencia),addTarefa(int,tarefa)
		//esta classe ira chamar a hibernateUtil para fazer as sessions factory etc.
	}
