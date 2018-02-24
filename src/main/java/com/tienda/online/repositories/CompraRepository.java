package com.tienda.online.repositories;

import org.springframework.data.repository.CrudRepository;

import com.tienda.online.modelo.Compra;

public interface CompraRepository extends CrudRepository<Compra, Integer>{

	Compra findById(Integer id);
	
}
