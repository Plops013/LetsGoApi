package com.qintess.letsgo.api.service;

import org.springframework.stereotype.Service;

import com.qintess.lestgo.api.models.Ingresso;
import com.qintess.lestgo.api.models.Pedido;

@Service
public class GeradorIngressos {
	
	public void gerarIngressos(Pedido pedido) {
		for ( int i = 1; i <= pedido.getQuantidadeIngressos() ; i++) {
			Ingresso ingresso = new Ingresso();
			pedido.addIngresso(ingresso);
		}
	}
	
}
