package com.qintess.letsgo.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qintess.letsgo.api.models.Pedido;

@Service
public class ValidaPedido {

	@Autowired
	private UsuarioService usuarioService;
	
	public boolean validaQuantidade(Pedido pedido, int quantidade) {
		if(pedido.getQuantidadeIngressos() > 4) {
			return false;
		} else if ( 
				usuarioService.ingressoCompradoPorUsuario(pedido.getEvento(), pedido.getUsuario()) >= 4 
				|| usuarioService.ingressoCompradoPorUsuario(pedido.getEvento(), pedido.getUsuario()) + pedido.getQuantidadeIngressos() > 4) {
			return false;
		} else if (quantidade < 0){
			return false;
		} else {
		return true;
		}
	}
	
}
