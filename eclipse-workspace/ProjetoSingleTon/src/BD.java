import java.sql.Connection;
import java.sql.DriverManager;

public class BD {
	private static final String PWD = null;
	private static final String USR = null;
	private static Connection con = null;
	
	private BD() {
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			String url = "jdbc:ucanaccess://./Agenda.mdb";
			con = DriverManager.getConnection(url, USR, PWD);
		}catch(Exception e) {
			System.err.println("Ops! Algo deu errado: " + e.getMessage());
		}
	}
	public static Connection getConexão() {
		if(con == null)
			new BD();
		return con;
		
	}
 
}
