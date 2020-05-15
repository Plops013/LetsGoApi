package com.qintess.letsgo.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qintess.letsgo.api.models.Pedido;
import com.qintess.letsgo.api.models.Usuario;
import com.qintess.letsgo.api.service.EventoService;
import com.qintess.letsgo.api.service.GeradorIngressos;
import com.qintess.letsgo.api.service.PedidoService;
import com.qintess.letsgo.api.service.UsuarioService;
import com.qintess.letsgo.api.service.ValidaPedido;

@RestController
public class PedidoController {

	@Autowired
	private PedidoService pedidoService;
	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private EventoService eventoService;
	@Autowired
	private GeradorIngressos geradorIngressos;
	@Autowired
	private ValidaPedido validaPedido;

	@GetMapping("/pedido")
	public List<Pedido> findAll(){
		return this.pedidoService.findAll();
	}

	@GetMapping("/usuario/{id}/pedido")
	public List<Pedido> findByUsuario(@PathVariable("id") int id){
		Usuario usuario = this.usuarioService.findById(id);
		return this.pedidoService.findByUsuario(usuario);
	}

	@GetMapping("/pedido/{id}")
	public Pedido findById(@PathVariable("id") int id) {
		return this.pedidoService.findById(id);
	}

	@PostMapping("/pedido")
	public Pedido save(@RequestBody Pedido pedido) throws Exception {

		pedido.setUsuario(usuarioService.findById(pedido.getUsuario().getId()));
		pedido.setEvento(eventoService.findById(pedido.getEvento().getId()));

		if (validaPedido.validaQuantidade(pedido, pedido.getQuantidadeIngressos()))
		{
			this.geradorIngressos.gerarIngressos(pedido);
		} else {
			throw new Exception("Quantidade Maxima de ingresso limitada a 4 por pessoa");
		}
		return this.pedidoService.save(pedido);
	}

	@PutMapping("/pedido")
	public Pedido update(@RequestBody Pedido pedido) throws Exception {
		return this.save(pedido);
	}

	@DeleteMapping("/pedido/{id}")
	public void deleteById(@PathVariable("id") int id) {
		this.pedidoService.deleteById(id);
	}

}
