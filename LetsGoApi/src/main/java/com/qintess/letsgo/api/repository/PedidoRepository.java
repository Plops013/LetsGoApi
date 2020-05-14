package com.qintess.letsgo.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qintess.letsgo.api.models.Pedido;
import com.qintess.letsgo.api.models.Usuario;

public interface PedidoRepository extends JpaRepository<Pedido, Integer>{

	public List<Pedido> findByUsuario(Usuario usuario);
	
}
