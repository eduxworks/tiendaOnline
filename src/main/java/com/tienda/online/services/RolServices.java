package com.tienda.online.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tienda.online.modelo.Rol;
import com.tienda.online.repositories.RolRepository;

@Service
public class RolServices {

	private RolRepository rolRepository;
	
	@Autowired
	public RolServices(RolRepository rolRepository) {
		super();
		this.rolRepository = rolRepository;
	}
	
	public Rol guardar(Rol rol) {
		return rolRepository.save(rol);
	}
	
	public void eliminar(Integer id) {
		rolRepository.delete(id);
	}
	
	public List<Rol> obtenerTodos() {
		return (List<Rol>) rolRepository.findAll();
	}
	
}
