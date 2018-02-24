package com.tienda.online.repositories;

import org.springframework.data.repository.CrudRepository;

import com.tienda.online.modelo.IngresoProducto;

public interface IngresoProductoRepository extends CrudRepository<IngresoProducto, Integer>{
	
	IngresoProducto findById(Integer id);
}
