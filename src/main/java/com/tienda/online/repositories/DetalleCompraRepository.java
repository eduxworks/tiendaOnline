package com.tienda.online.repositories;

import org.springframework.data.repository.CrudRepository;

import com.tienda.online.modelo.DetalleCompra;

public interface DetalleCompraRepository extends CrudRepository<DetalleCompra, Integer>{
	DetalleCompra findById(Integer id);
}
