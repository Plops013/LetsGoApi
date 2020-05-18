package com.qintess.letsgo.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qintess.letsgo.api.models.Evento;
import com.qintess.letsgo.api.models.Papel;
import com.qintess.letsgo.api.models.Pedido;
import com.qintess.letsgo.api.models.Usuario;
import com.qintess.letsgo.api.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private PedidoService pedidoService;

	public Usuario findById(int id) {
		return this.usuarioRepository.findById(id).get();
	}

	public List<Usuario> findAll(){
		return this.usuarioRepository.findAll();
	}

	public List<Usuario> findByPapel(Papel papel){
		return this.usuarioRepository.findByPapel(papel);
	}
	public Usuario save(Usuario usuario) throws Exception {
		if (this.alreadyRegistered(usuario)) {
			throw new Exception("Email ja registrado!");
		} else {
		return this.usuarioRepository.save(usuario);
		}
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
	
	public Usuario findByEmail(String email){
		return this.usuarioRepository.findByEmail(email);
	}
	
	private boolean alreadyRegistered(Usuario usuario) {
		if(this.findByEmail(usuario.getEmail()) != null && usuario.getId() != this.findByEmail(usuario.getEmail()).getId()) {
			return true;
		} else {
			return false;
		}
	}
}
