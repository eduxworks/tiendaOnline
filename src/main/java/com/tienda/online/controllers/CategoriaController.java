package com.tienda.online.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tienda.online.modelo.Categoria;
import com.tienda.online.services.CategoriaServices;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {
	
	private static final Logger logger=org.slf4j.LoggerFactory.getLogger(CategoriaController.class);
	
	private CategoriaServices categoriaServices;
	
	@Autowired
	public CategoriaController(CategoriaServices categoriaServices) {
		super();
		this.categoriaServices = categoriaServices;
	}
	
	@PostMapping(produces="application/json")
	public Categoria guardar(@RequestBody @Validated Categoria categoria) {
		try {
			return categoriaServices.guardar(categoria);
		} catch (DataIntegrityViolationException e) {
			logger.info("Error en el consumo del servicio guardarCategoria "+ e.getMessage());
			throw new DataIntegrityViolationException(e.getMessage());
		}
	}
	
	@GetMapping(produces="application/json")
	public List<Categoria> obtenerTodos() {
		try {
			return categoriaServices.obtenerTodos();
		} catch (DataIntegrityViolationException e) {
			logger.info("Error en el consumo del servicio obtener Categoria "+ e.getMessage());
			throw new DataIntegrityViolationException(e.getMessage());
		}
	}
	
	@PutMapping(produces="application/json")
	public Categoria actualizar(@RequestBody @Validated Categoria categoria) {
		try {
			return categoriaServices.guardar(categoria);
		} catch (DataIntegrityViolationException e) {
			logger.info("Error en el consumo del servicio actualizar "+ e.getMessage());
			throw new DataIntegrityViolationException(e.getMessage());
		}
	}
	
	@RequestMapping(path="/{id}", produces="application/json", method= RequestMethod.DELETE)
	public void eliminar(@PathVariable (value="id") String id) {
		try {
			categoriaServices.eliminar(id);
		} catch (DataIntegrityViolationException e) {
			logger.info("Error en el consumo del servicio eliminar "+ e.getMessage());
			throw new DataIntegrityViolationException(e.getMessage());
		}
	}
	

}
