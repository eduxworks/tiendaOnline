package com.tienda.online.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tienda.online.modelo.Categoria;
import com.tienda.online.repositories.CategoriaRepository;

@Service
public class CategoriaServices {
	
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	public CategoriaServices(CategoriaRepository categoriaRepository) {
		super();
		this.categoriaRepository = categoriaRepository;
	} 
	
	public Categoria guardar(Categoria categoria) {
		return categoriaRepository.save(categoria);
	}
	
	public void eliminar(String id) {
		categoriaRepository.delete(id);
	}
	
	public List<Categoria> obtenerTodos() {
		return (List<Categoria>) categoriaRepository.findAll();
	}
	
}
