package com.qintess.letsgo.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qintess.lestgo.api.models.CasaDeShow;
import com.qintess.lestgo.api.models.Usuario;

public interface CasaDeShowRepository extends JpaRepository<CasaDeShow, Integer>{

	public List<CasaDeShow> findByUsuario(Usuario usuario);
	
}
