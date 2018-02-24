package com.tienda.online.repositories;

import org.springframework.data.repository.CrudRepository;

import com.tienda.online.modelo.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Integer>{
	
	Usuario findById(Integer id);
}
