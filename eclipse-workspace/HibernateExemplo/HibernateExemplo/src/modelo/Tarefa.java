package modelo;

public class Tarefa {

	private Integer id,usr_id;
	private String titulo,descricao;
	
	public Tarefa(String titulo,String descricao) {
	
	}
	public Tarefa() {
		
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUsr_id() {
		return usr_id;
	}
	public void setUsr_id(Integer usr_id) {
		this.usr_id = usr_id;
	}
	public String getTarefa() {
		return titulo;
	}
	public void setTarefa(String tarefa) {
		this.titulo = tarefa;
	}
	public String getDesc() {
		return descricao;
	}
	public void setDesc(String desc) {
		this.descricao = desc;
	}	
}
