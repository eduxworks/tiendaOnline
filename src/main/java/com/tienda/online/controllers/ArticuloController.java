package com.tienda.online.controllers;

import java.util.List;
import java.util.NoSuchElementException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tienda.online.modelo.Articulo;
import com.tienda.online.services.ArticuloServices;

@RestController
@RequestMapping("/articulo")
public class ArticuloController {
	
	private static Logger logger = LoggerFactory.getLogger(ArticuloController.class);
	
	
	private ArticuloServices articuloServices;

	@Autowired
	public ArticuloController(ArticuloServices articuloServices) {
		super();
		this.articuloServices = articuloServices;
	}
	
	@PostMapping(produces="application/json")
	public Articulo guardar(@RequestBody @Validated Articulo articulo) {
		try
		{
			return articuloServices.guardar(articulo);
		}catch(NoSuchElementException e) {
			logger.info("Error en el consumo del servicio guardarArticulo: " + e.getMessage());
			throw new NoSuchElementException("Error en elconsumo del servicio guardar");
		}
	}
	
	

	@GetMapping(produces="application/json")
	public List<Articulo> obtenerTodos(){
		try {	
				return articuloServices.obtenerTodos();
		} catch (DataIntegrityViolationException e) {
			logger.info("Error en el consumo del servicio obtenerTodosArticulo: " + e.getMessage());
			throw new DataIntegrityViolationException(e.getMessage());
		}
	}
	
	@RequestMapping(path="/{id}", produces="application/json", method= RequestMethod.DELETE)
	public void eliminar(Integer id) {
		try {
			articuloServices.eliminar(id);
		} catch (DataIntegrityViolationException e) {
			logger.info("Error en el consumo del servicio eliminarArticulo: " + e.getMessage());
			throw new DataIntegrityViolationException(e.getMessage());
		}
	}
	

}
