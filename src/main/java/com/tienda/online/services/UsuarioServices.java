package com.tienda.online.services;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tienda.online.modelo.Usuario;
import com.tienda.online.repositories.UsuarioRepository;

@Service
public class UsuarioServices {

	private UsuarioRepository usuarioRepository;
	
	@Autowired
	public UsuarioServices(UsuarioRepository usuarioRepository) {
		super();
		this.usuarioRepository = usuarioRepository;
	}
	
	public Usuario guardar(Usuario usuario) {
		usuario.setFecha(new Date());
		return usuarioRepository.save(usuario);
	}
	
	public void eliminar(Integer id) {
		usuarioRepository.delete(id);
	}
	
	public List<Usuario> obtenerTodos() {
		return (List<Usuario>) usuarioRepository.findAll();
	}
}
