package com.qintess.letsgo.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qintess.letsgo.api.models.CasaDeShow;
import com.qintess.letsgo.api.models.Usuario;
import com.qintess.letsgo.api.repository.CasaDeShowRepository;

@Service
public class CasaDeShowService {

	@Autowired
	private CasaDeShowRepository casaDeShowRepository;
	
	public CasaDeShow findById(int id) {
		return this.casaDeShowRepository.findById(id).get();
	}
	
	public CasaDeShow save(CasaDeShow casaDeShow) {
		return this.casaDeShowRepository.save(casaDeShow);
	}
	
	public List<CasaDeShow> findAll(){
		return this.casaDeShowRepository.findAll();
	}
	
	public List<CasaDeShow> findByUsuario(Usuario usuario){
		return this.casaDeShowRepository.findByUsuario(usuario);
	}
	
	public CasaDeShow merge(CasaDeShow casaDeShow) throws Exception {
		if(casaDeShow.getId() == 0) {
			throw new Exception("Casa De Show não encontrada");
		} else {
		return this.save(casaDeShow);
		}
	}
	
	public void deleteById(int id) {
		this.casaDeShowRepository.deleteById(id);
	}
	
}
