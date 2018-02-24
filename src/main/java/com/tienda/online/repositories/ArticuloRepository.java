package com.tienda.online.repositories;


import org.springframework.data.repository.CrudRepository;

import com.tienda.online.modelo.Articulo;

public interface ArticuloRepository extends CrudRepository<Articulo, Integer>{
	
	Articulo findById(Integer id);
	
	//@Query("select p from Articulo p where p.id=?1")
	//Articulo buscarPorCodigo(Integer id);
	
}

