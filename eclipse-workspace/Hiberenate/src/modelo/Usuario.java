package modelo;

public class Usuario {

	private int id;
	private String nome;
	private String sobrenome;

	public Usuario() {
		nome = "<não informado>";
		nome = "<não informado>";
	}

	public Usuario(String nome, String sobrenome) {
		this.nome = nome;
		this.sobrenome = sobrenome;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	@Override
	public String toString() {
		return nome + " " + sobrenome;
	}
}
