package com.qintess.letsgo.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qintess.letsgo.api.models.Papel;
import com.qintess.letsgo.api.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

	public Usuario findByEmail(String email);
	
	public  List<Usuario> findByPapel(Papel papel);
	
}
