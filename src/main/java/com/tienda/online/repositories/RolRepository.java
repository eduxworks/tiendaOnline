package com.tienda.online.repositories;

import org.springframework.data.repository.CrudRepository;

import com.tienda.online.modelo.Rol;

public interface RolRepository extends CrudRepository<Rol, Integer>{
	
	Rol findById(Integer id);
}
