package com.qintess.letsgo.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qintess.letsgo.api.models.CasaDeShow;
import com.qintess.letsgo.api.models.Evento;
import com.qintess.letsgo.api.repository.EventoRepository;

@Service
public class EventoService {

	@Autowired
	private EventoRepository eventoRepository;
	
	public Evento save(Evento evento) {
		return this.eventoRepository.save(evento);
	}
	
	public Evento findById(int id) {
		return this.eventoRepository.findById(id).get();
	}
	
	public List<Evento> findAll(){
		return this.eventoRepository.findAll();
	}
	
	public List<Evento> findByCasaDeShow(CasaDeShow casaDeShow){
		return this.eventoRepository.findByCasaDeShow(casaDeShow);
	}
	
	public void deleteById(int id) {
		this.eventoRepository.deleteById(id);
	}
	
	public Evento merge(Evento evento) {
		return this.save(evento);
	}
	
}
