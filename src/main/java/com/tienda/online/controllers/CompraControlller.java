package com.tienda.online.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tienda.online.modelo.Compra;
import com.tienda.online.services.CompraServices;


@RestController
@RequestMapping("/compra")
public class CompraControlller {

	private static final Logger logger = LoggerFactory.getLogger(CompraControlller.class);
	
	private CompraServices compraServices;

	@Autowired
	public CompraControlller(CompraServices compraServices) {
		super();
		this.compraServices = compraServices;
	}
	
	@GetMapping(produces="application/json")
	public List<Compra> obtenerTodos(){
		try {
			return compraServices.obtenerTodos();
		} catch (DataIntegrityViolationException e) {
			logger.info("Error en el consumo del servicio obtenerTodosCompra: " + e.getMessage());
			throw new DataIntegrityViolationException(e.getMessage());
		}
		
	}
	
	@PostMapping(produces="application/json")
	public Compra guardar(@RequestBody @Validated Compra compra) {
		try {
			return compraServices.guardar(compra);
		} catch (DataIntegrityViolationException e) {
			logger.info("Error en el consumo del servicio guardarCompra: " + e.getMessage());
			throw new DataIntegrityViolationException(e.getMessage());
		}
	}
	
	@RequestMapping(path="/{id}", produces="application/json", method=RequestMethod.DELETE)
	public void eliminar(@PathVariable(value="id") Integer id) {
		try {
			compraServices.eliminar(id);
		} catch (DataIntegrityViolationException e) {
			logger.info("Error en el consumo del servicio eliminarCompra: " + e.getMessage());
			throw new DataIntegrityViolationException(e.getMessage());
		}
	}
	
	
	
}
