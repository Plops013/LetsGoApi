package com.qintess.letsgo.api.models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

@Entity
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne(optional = false)
	private Usuario usuario;
	@Column(columnDefinition = "DECIMAL(10,2)")
	private Double total = 0D;
	@Column(nullable = false)
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	private LocalDateTime dataCompra;
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER, mappedBy = "pedido")
	private List<Ingresso> ingressos = new ArrayList<>();
	@Column(nullable = false)
	private int quantidadeIngressos;
	@ManyToOne
	@JoinColumn(name = "evento_id")
	private Evento evento;
	@Transient
	private String dataString;
	
	public void addIngresso(Ingresso ingresso) {
		this.ingressos.add(ingresso);
	}
	
	public void removeIngresso(Ingresso ingresso) {
		this.ingressos.remove(ingresso);
	}
	
	public String getDataString() {
		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy HH:mm");
			String inicioFormatado = dataCompra.format(formatter);
			String retorno = inicioFormatado;
			return retorno;
		} catch(Exception e) {
			e.printStackTrace();
			return "erro na conversão da data";
		}
	}
	
	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public LocalDateTime getDataCompra() {
		return dataCompra;
	}
	public void setDataCompra(LocalDateTime dataCompra) {
		this.dataCompra = dataCompra;
	}

	public List<Ingresso> getIngressos() {
		return ingressos;
	}

	public void setIngressos(List<Ingresso> ingressos) {
		this.ingressos = ingressos;
	}

	public void setDataString(String dataString) {
		this.dataString = dataString;
	}

	public int getQuantidadeIngressos() {
		return quantidadeIngressos;
	}

	public void setQuantidadeIngressos(int quantidadeIngressos) {
		this.quantidadeIngressos = quantidadeIngressos;
	}

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", usuario=" + usuario + ", total=" + total + ", dataCompra=" + dataCompra
				+ ", ingressos=" + ingressos + ", quantidadeIngressos=" + quantidadeIngressos + ", evento=" + evento
				+ ", dataString=" + dataString + "]";
	}

}
