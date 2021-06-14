package modelo;

import java.util.HashSet;
import java.util.Set;

public class Usuario {

	private int id;
	private String nome;
	private String sobrenome;
	private Set<Tarefa> listaDeTarefas;

	public Usuario() {
		listaDeTarefas = new HashSet<Tarefa>(); 
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

	public Set<Tarefa> getListaDeTarefas() {
		
		return listaDeTarefas;
	}

	public void setListaDeTarefas(Set<Tarefa> listaDeTarefas) {
		this.listaDeTarefas = listaDeTarefas;
	}
	
	public void addTarefa(Tarefa tarefa) {
		listaDeTarefas.add(tarefa);
	}

	@Override
	public String toString() {
		String str = nome + " " + sobrenome;
		for (Tarefa task : listaDeTarefas) {
			str += "\n+-> " + task;
		}
		return str;
	}
}
