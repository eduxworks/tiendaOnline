package com.tienda.online.repositories;

import org.springframework.data.repository.CrudRepository;

import com.tienda.online.modelo.Categoria;

public interface CategoriaRepository extends CrudRepository<Categoria, String>{
	
	Categoria findById(String id);
}
