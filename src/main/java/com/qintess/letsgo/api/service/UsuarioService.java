package com.qintess.letsgo.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qintess.letsgo.api.models.Evento;
import com.qintess.letsgo.api.models.Pedido;
import com.qintess.letsgo.api.models.Usuario;
import com.qintess.letsgo.api.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private PedidoService pedidoService;

	public ResponseEntity<Usuario> findById(int id) {
		Usuario usuario = this.usuarioRepository.findById(id).get();
		return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
	}

	public Usuario save(Usuario usuario) {
		return this.usuarioRepository.save(usuario);
	}

	public Usuario merge(Usuario usuario) throws Exception {
		if(usuario.getId() == 0) {
			throw new Exception("Usuario não encontrado");
		} else {
			return this.save(usuario);
		}
	}

	public void deleteById(int id) {
		this.usuarioRepository.deleteById(id);
	}

	public int ingressoCompradoPorUsuario(Evento evento, Usuario usuario) {
		int quantidadeJaComprados = 0;

		List<Pedido> pedidosUsuario = pedidoService.findByUsuario(usuario);
		if(!pedidosUsuario.isEmpty()) {
			for (Pedido pedido : pedidosUsuario) {
				Evento eventoDoPedido = pedido.getEvento();

				if(eventoDoPedido.equals(evento)) {
					quantidadeJaComprados += pedido.getQuantidadeIngressos();
				}
			}
			return quantidadeJaComprados;
		} else {
			return 0;
		}
	}
}
