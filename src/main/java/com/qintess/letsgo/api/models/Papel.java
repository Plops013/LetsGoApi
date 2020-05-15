package com.qintess.letsgo.api.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties(value = "usuarios")
public class Papel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id = 0;
	@Column(nullable = false, length = 50)
	private String nome;
	@OneToMany(mappedBy = "papel")
	private List<Usuario> usuarios = new ArrayList<>();
	
	public Papel() {}
	public Papel(int id, String nome, List<Usuario> usuarios) {
		super();
		this.id = id;
		this.nome = nome;
		this.usuarios = usuarios;
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
	public List<Usuario> getUsuarios() {
		return usuarios;
	}
	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
}
