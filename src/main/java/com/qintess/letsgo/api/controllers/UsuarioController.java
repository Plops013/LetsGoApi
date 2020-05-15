package com.qintess.letsgo.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qintess.letsgo.api.models.Usuario;
import com.qintess.letsgo.api.service.UsuarioService;

@RestController
@CrossOrigin
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	@PostMapping("")
	public Usuario createUsuario(@RequestBody Usuario usuario) {
		return this.usuarioService.save(usuario);
	}
	
	@GetMapping("/{id}")
	public Usuario findById(@PathVariable("id") int id){
		return this.usuarioService.findById(id);
	}
	
	@PutMapping("")
	public Usuario update(@RequestBody Usuario usuario) {
		return this.usuarioService.merge(usuario);
	}
	
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable("id") int id) {
		this.usuarioService.deleteById(id);
	}
	
}
