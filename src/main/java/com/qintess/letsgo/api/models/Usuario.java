package com.qintess.letsgo.api.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

@Entity
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id = 0;
	@Column(nullable = false, length = 50)
	private String nome;
	@Column(nullable = false, length = 70)
	private String sobrenome;
	@Column(nullable = false, length = 100, unique = true)
	private String email;
	@Column(nullable = false, length = 15)
	private String telefone;
	@Column(nullable = false, length = 160)
	private String senha;
	@JsonSerialize(using = LocalDateSerializer.class)
	@JsonDeserialize(using = LocalDateDeserializer.class)
	private LocalDate dataNascimento;
	@ManyToOne
	private Papel papel;
	@JsonIgnore
	@OneToMany(mappedBy = "usuario", cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE})
	private List<CasaDeShow> casasDeShow = new ArrayList<CasaDeShow>();
	
	public Papel getPapel() {
		return papel;
	}

	public void setPapel(Papel papel) {
		this.papel = papel;
	}

	public List<CasaDeShow> getCasasDeShow() {
		return casasDeShow;
	}

	public void setCasasDeShow(List<CasaDeShow> casasDeShow) {
		this.casasDeShow = casasDeShow;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nome=" + nome + ", sobrenome=" + sobrenome + ", email=" + email + ", telefone="
				+ telefone + ", senha=" + senha + ", dataNascimento=" + dataNascimento + ", papel=" + papel
				+ ", casasDeShow=" + casasDeShow + "]";
	}
	
	
	
}
