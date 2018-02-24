package com.tienda.online.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tienda.online.modelo.Articulo;
import com.tienda.online.repositories.ArticuloRepository;

@Service
public class ArticuloServices {
	
	private ArticuloRepository articuloRepository;
	
	@Autowired
	public ArticuloServices(ArticuloRepository articuloRepository) {
		super();
		this.articuloRepository = articuloRepository;
	}
	
	public Articulo guardar(Articulo articulo) {
		return articuloRepository.save(articulo);
	}
	
	public void eliminar(Integer id) {
		articuloRepository.delete(id);
	}
	
	public List<Articulo> obtenerTodos() {
		return (List<Articulo>) articuloRepository.findAll();
	}
	
}
