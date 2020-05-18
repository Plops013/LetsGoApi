package com.qintess.letsgo.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qintess.letsgo.api.models.Evento;
import com.qintess.letsgo.api.models.Pedido;
import com.qintess.letsgo.api.models.Usuario;
import com.qintess.letsgo.api.repository.PedidoRepository;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;
	@Autowired
	private EventoService eventoService;
	
	public Pedido save(Pedido pedido) throws Exception {
		if(eventoService.temIngressos(pedido.getQuantidadeIngressos(), pedido.getEvento())) {
		pedido.setTotal(pedido.getQuantidadeIngressos() * pedido.getEvento().getPreco());
		Evento eventoAtualizado = pedido.getEvento();
		eventoAtualizado.setQuantidadeIngressos(eventoAtualizado.getQuantidadeIngressos() - pedido.getQuantidadeIngressos());
		this.eventoService.merge(eventoAtualizado);
		return this.pedidoRepository.save(pedido);
		} else {
			throw new Exception("Evento não tem mais ingressos disponiveis");
		}
	}
	
	public Pedido findById(int id) {
		return this.pedidoRepository.findById(id).get();
	}
	
	public List<Pedido> findAll(){
		return this.pedidoRepository.findAll();
	}
	
	public List<Pedido> findByUsuario(Usuario usuario){
		return this.pedidoRepository.findByUsuario(usuario);
	}
	
	public Pedido merge(Pedido pedido) throws Exception {
		if(pedido.getId() == 0) {
			throw new Exception("Pedido não encontrado");
		} else {
		return this.save(pedido);
		}
	}
	
	public void deleteById(int id) {
		this.pedidoRepository.deleteById(id);
	}
	
}

