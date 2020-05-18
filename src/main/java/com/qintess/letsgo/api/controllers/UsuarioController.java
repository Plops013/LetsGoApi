package com.qintess.letsgo.api.controllers;

import java.util.List;

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

import com.qintess.letsgo.api.models.Papel;
import com.qintess.letsgo.api.models.Usuario;
import com.qintess.letsgo.api.service.UsuarioService;

@RestController
@CrossOrigin
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	@PostMapping("")
	public Usuario createUsuario(@RequestBody Usuario usuario) throws Exception {
		return this.usuarioService.save(usuario);
	}
	
	//This is just for example. When i implement authentication i'll remove this endpoint.
	@GetMapping("/organizadores")
	public List<Usuario> findOrganizadores(){
		return this.usuarioService.findByPapel(new Papel(2, "organizador"));
	}
	
	@GetMapping("/{id}")
	public Usuario findById(@PathVariable("id") int id){
		return this.usuarioService.findById(id);
	}
	
	@GetMapping("")
	public List<Usuario> findAll(){
		return this.usuarioService.findAll();
	}
	
	@PutMapping("")
	public Usuario update(@RequestBody Usuario usuario) throws Exception {
		return this.usuarioService.merge(usuario);
	}
	
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable("id") int id) throws Exception {
		System.out.println(this.usuarioService.findById(id).getCasasDeShow().stream().filter( c -> c.getEventos().size() > 0).count());
		
		if(this.usuarioService.findById(id).getCasasDeShow().stream().filter( c -> c.getEventos().size() > 0).count() > 0) {
			throw new Exception("Usuario tem casa de shows com eventos registrados");
		} else {
			this.usuarioService.deleteById(id);
		}
	}
}
