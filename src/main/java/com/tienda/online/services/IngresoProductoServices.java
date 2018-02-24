package com.tienda.online.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tienda.online.modelo.IngresoProducto;
import com.tienda.online.repositories.IngresoProductoRepository;

@Service
public class IngresoProductoServices {
	
	private IngresoProductoRepository ingresoProductoRepository;
	
	@Autowired
	public IngresoProductoServices(IngresoProductoRepository ingresoProductoRepository) {
		super();
		this.ingresoProductoRepository = ingresoProductoRepository;
	}
	
	public IngresoProducto guardar(IngresoProducto ingresoProducto) {
		return ingresoProductoRepository.save(ingresoProducto);
	}
	
	public void eliminar(Integer id) {
		ingresoProductoRepository.delete(id);
	}
	
	public List<IngresoProducto> obtenerTodos() {
		return (List<IngresoProducto>) ingresoProductoRepository.findAll();
	}
	
}
