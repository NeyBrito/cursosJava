package modelo;

public class Usuario {
private int id;
public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}
private String nome,sobrenome;
public Usuario(){
	
}

public Usuario(String nome, String sobrenome) {
	super();
	this.nome = nome;
	this.sobrenome = sobrenome;
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
}
