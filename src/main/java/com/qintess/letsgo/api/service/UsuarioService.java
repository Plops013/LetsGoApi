package com.qintess.letsgo.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qintess.letsgo.api.models.Usuario;
import com.qintess.letsgo.api.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public Usuario findById(int id) {
		return this.usuarioRepository.findById(id).get();
	}
	
	public Usuario save(Usuario usuario) {
		return this.usuarioRepository.save(usuario);
	}
	
	public Usuario merge(Usuario usuario) {
		return this.save(usuario);
	}
	
	public void deleteById(int id) {
		this.usuarioRepository.deleteById(id);
	}
}
