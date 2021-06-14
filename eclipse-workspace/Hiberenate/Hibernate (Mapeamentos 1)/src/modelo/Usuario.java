package modelo;

public class Usuario {

	private int id;
	private String nome;
	private String sobrenome;
	private Tarefa tarefa;

	public Usuario() {
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

	public Tarefa getTarefa() {
		return tarefa;
	}

	public void setTarefa(Tarefa tarefa) {
		this.tarefa = tarefa;
	}

	@Override
	public String toString() {
		String str = nome + " " + sobrenome;
		if (tarefa != null)
			str += "\n+-> " + tarefa;
		return str;
	}
}
