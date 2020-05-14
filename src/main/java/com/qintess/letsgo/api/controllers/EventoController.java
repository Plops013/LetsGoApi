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
import com.qintess.letsgo.api.models.Evento;
import com.qintess.letsgo.api.service.CasaDeShowService;
import com.qintess.letsgo.api.service.EventoService;

@RestController
public class EventoController {

	@Autowired
	private EventoService eventoService;
	@Autowired
	private CasaDeShowService casaDeShowService;
	
	@GetMapping("/evento")
	public List<Evento> findAll(){
		return this.eventoService.findAll();
	}
	
	@GetMapping("/casadeshow/{id}/evento")
	public List<Evento> findByCasaDeShow(@PathVariable("id") int id){
		CasaDeShow casaDeShow = this.casaDeShowService.findById(id);
		return this.eventoService.findByCasaDeShow(casaDeShow);
	}
	
	@GetMapping("/evento/{id}")
	public Evento findById(@PathVariable("id") int id) {
		return this.eventoService.findById(id);
	}

	@PostMapping("/evento")
	public Evento save(@RequestBody Evento evento) {
		return this.eventoService.save(evento);
	}

	@PutMapping("/evento")
	public Evento update(@RequestBody Evento evento) {
		return this.save(evento);
	}

	@DeleteMapping("/evento/{id}")
	public void deleteById(@PathVariable("id") int id) {
		this.eventoService.deleteById(id);
	}
}
