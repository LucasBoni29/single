package br.com.single.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_lobo")
public class Single {
	
	@Id
	@Column(name="id")
	private int id;
	@Column(name="nome", length=60)
	private String nome;
	@Column(name="patente")
	private String patente;
	@Column(name="nivel")
	private double nivel;
	
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
	public String getPatente() {
		return patente;
	}
	public void setPatente(String patente) {
		this.patente = patente;
	}
	public double getNivel() {
		return nivel;
	}
	public void setNivel(double nivel) {
		this.nivel = nivel;
	}
	
	
}
