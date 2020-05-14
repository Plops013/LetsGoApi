package com.qintess.letsgo.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qintess.letsgo.api.models.CasaDeShow;
import com.qintess.letsgo.api.models.Evento;

public interface EventoRepository extends JpaRepository<Evento, Integer> {

	public List<Evento> findByCasaDeShow(CasaDeShow casaDeShow);
	
}
