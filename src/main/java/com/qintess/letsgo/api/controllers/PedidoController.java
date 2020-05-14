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
import com.qintess.letsgo.api.service.PedidoService;
import com.qintess.letsgo.api.service.UsuarioService;

@RestController
public class PedidoController {

	@Autowired
	private PedidoService pedidoService;
	@Autowired
	private UsuarioService usuarioService;
	
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
	public Pedido save(@RequestBody Pedido pedido) {
		return this.pedidoService.save(pedido);
	}
	
	@PutMapping("/pedido")
	public Pedido update(@RequestBody Pedido pedido) {
		return this.save(pedido);
	}
	
	@DeleteMapping("/pedido/{id}")
	public void deleteById(@PathVariable("id") int id) {
		this.pedidoService.deleteById(id);
	}
	
}
