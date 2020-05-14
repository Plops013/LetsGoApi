package com.qintess.letsgo.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qintess.lestgo.api.models.Pedido;
import com.qintess.lestgo.api.models.Usuario;
import com.qintess.letsgo.api.repository.PedidoRepository;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;
	
	public Pedido save(Pedido pedido) {
		return this.pedidoRepository.save(pedido);
	}
	
	public Pedido findById(int id) {
		return this.pedidoRepository.findById(id).get();
	}
	
	public List<Pedido> findAll(){
		return this.pedidoRepository.findAll();
	}
	
	public List<Pedido> findByUsuario(Usuario usuario){
		return this.findByUsuario(usuario);
	}
	
	public Pedido merge(Pedido pedido) {
		return this.save(pedido);
	}
	
	public void deleteById(int id) {
		this.pedidoRepository.deleteById(id);
	}
	
}

