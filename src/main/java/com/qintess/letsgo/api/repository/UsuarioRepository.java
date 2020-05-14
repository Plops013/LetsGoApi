package com.qintess.letsgo.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qintess.letsgo.api.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

	public Usuario findByEmail(String email);
	
}
