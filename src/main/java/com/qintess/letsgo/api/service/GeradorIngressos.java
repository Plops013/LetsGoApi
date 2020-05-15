package com.qintess.letsgo.api.service;

import org.springframework.stereotype.Service;

import com.qintess.letsgo.api.models.Ingresso;
import com.qintess.letsgo.api.models.Pedido;

@Service
public class GeradorIngressos {
	
	public void gerarIngressos(Pedido pedido) {
		for ( int i = 1; i <= pedido.getQuantidadeIngressos() ; i++) {
			Ingresso ingresso = new Ingresso();
			ingresso.setPedido(pedido);
			pedido.addIngresso(ingresso);
		}
	}
	
}
