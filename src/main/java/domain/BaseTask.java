package domain;

import java.time.Instant;
import java.time.LocalDate;

public abstract class BaseTask {

	private Long id = Instant.now().getEpochSecond();
	private String titulo;
	private String descricao;
	private LocalDate prazo;
	
	public BaseTask() {
		
	}
	
	public BaseTask(String titulo, String descricao, LocalDate prazo) {
		this.titulo = titulo;
		this.descricao = descricao;
		this.prazo = prazo;
	}
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public LocalDate getPrazo() {
		return prazo;
	}
	public void setPrazo(LocalDate prazo) {
		this.prazo = prazo;
	}

	public Long getId() {
		return id;
	}
	
	public abstract String getTipo();

	@Override
	public String toString() {
		return "BaseTask [id= " + id + ", titulo= " + titulo + ", descricao= " + descricao + ", prazo= " + prazo
				+ ", Tipo= " + getTipo() + "]";
	}
	
	
}
