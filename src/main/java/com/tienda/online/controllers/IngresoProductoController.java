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

import com.tienda.online.modelo.IngresoProducto;
import com.tienda.online.services.IngresoProductoServices;


@RestController
@RequestMapping("/ingreso_producto")
public class IngresoProductoController {

	private static final Logger logger = LoggerFactory.getLogger(IngresoProductoController.class);
	
	private IngresoProductoServices ingresoProductoServices;

	@Autowired
	public IngresoProductoController(IngresoProductoServices ingresoProductoServices) {
		super();
		this.ingresoProductoServices = ingresoProductoServices;
	}
	
	
	@GetMapping(produces="application/json")
	public List<IngresoProducto> obtenerTodos(){
		try {
			return ingresoProductoServices.obtenerTodos();
		} catch (DataIntegrityViolationException e) {
			logger.info("Error en el consumo del servicio obtenerTodosIngreso_Producto: " + e.getMessage());
			throw new DataIntegrityViolationException(e.getMessage());
		}
		
	}
	
	@PostMapping(produces="application/json")
	public IngresoProducto guardar(@RequestBody @Validated IngresoProducto ingresoProducto) {
		try {
			return ingresoProductoServices.guardar(ingresoProducto);
		} catch (DataIntegrityViolationException e) {
			logger.info("Error en el consumo del servicio guardarIngreso_Producto: " + e.getMessage());
			throw new DataIntegrityViolationException(e.getMessage());
		}
	}
	
	@RequestMapping(path="/{id}", produces="application/json", method=RequestMethod.DELETE)
	public void eliminar(@PathVariable(value="id") Integer id) {
		try {
			ingresoProductoServices.eliminar(id);
		} catch (DataIntegrityViolationException e) {
			logger.info("Error en el consumo del servicio eliminarIngreso_Producto: " + e.getMessage());
			throw new DataIntegrityViolationException(e.getMessage());
		}
	}
	
}
