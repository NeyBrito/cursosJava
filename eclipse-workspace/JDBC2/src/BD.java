import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BD {

	private Connection conexao = null;

	public void conectar() {
		if (conexao == null) {
			try {
				Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
				String url = "jdbc:ucanaccess://./Agenda.mdb";
				conexao = DriverManager.getConnection(url);
			} catch (ClassNotFoundException e) {
				System.err.println("Problemas ao carregar o driver: " + e.getMessage());
			} catch (SQLException e) {
				System.err.println("Problemas ao abrir a conexao com o BD: " + e.getMessage());
			}
		}
	}

	public boolean inserir(Contato c) {
		try {
			Statement st = conexao.createStatement();
			String sqlInserir = "INSERT INTO " + "contatos(nome,telefone,  email) " + "VALUES('" + c.getNome() + "','"
					+ c.getEmail() + "','" + c.getTelefone() + "')";
			st.execute(sqlInserir);
			st.close();
			return true;
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			
			return false;
		}
	}

	public boolean remover(Contato r) {
		return true;
	}
	
	public Contato getContatoByNome(String nome) {
		return null;
	}
	
	public List<Contato> getAllContatos(){
		List<Contato> lstContatos = new ArrayList<Contato>();
		Statement st = null;
		try {
			ResultSet rs = st.executeQuery("SELECT * FROM Contatos");
			while(rs.next()) {
				Contato c = new Contato();
				c.setNome(rs.getString("Nome"));
				c.setTelefone(rs.getString("Telefone"));
				c.setEmail(rs.getString("Email"));
				lstContatos.add(c);
				st = conexao.createStatement();
			}
			rs.close();
			st.close();
			
		
		} catch (SQLException e) {
		
			e.printStackTrace();
		}		
		return lstContatos;
		
	}

	public void desconectar() {
		if (conexao != null) {
			try{
				conexao.close();
			}catch(SQLException e) {
				System.err.println("Falha ao desconectar BD:" + e.getMessage());
			}
		}
	}
}
