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

import com.qintess.letsgo.api.models.CasaDeShow;
import com.qintess.letsgo.api.models.Usuario;
import com.qintess.letsgo.api.service.CasaDeShowService;
import com.qintess.letsgo.api.service.UsuarioService;

@RestController
public class CasaDeShowController {

	@Autowired
	private CasaDeShowService casaDeShowService;
	@Autowired 
	private UsuarioService usuarioService;
	
	@GetMapping("/casadeshow")
	public List<CasaDeShow> findAll() {
		return this.casaDeShowService.findAll();
	}
	
	@GetMapping("/casadeshow/{id}")
	public CasaDeShow finById(@PathVariable("id") int id) {
		return this.casaDeShowService.findById(id);
	}
	
	@GetMapping("/usuario/{idu}/casadeshow")
	public List<CasaDeShow> findByUsuario(@PathVariable("idu") int idUsuario){
		Usuario usuario = usuarioService.findById(idUsuario);
		return this.casaDeShowService.findByUsuario(usuario);
	}
	
	@PostMapping("/casadeshow")
	public CasaDeShow save(@RequestBody CasaDeShow casaDeShow) {
		return this.casaDeShowService.save(casaDeShow);
	}

	@PutMapping("/casadeshow")
	public CasaDeShow update(@RequestBody CasaDeShow casaDeShow) {
		return this.save(casaDeShow);
	}

	@DeleteMapping("/casadeshow/{id}")
	public void deleteById(@PathVariable("id") int id) {
		this.casaDeShowService.deleteById(id);
	}
}
