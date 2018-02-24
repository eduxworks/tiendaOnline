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

import com.tienda.online.modelo.DetalleCompra;
import com.tienda.online.services.DetalleCompraServices;




@RestController
@RequestMapping("/detalleCompra")
public class DetalleCompraController {
	
private static final Logger logger = LoggerFactory.getLogger(DetalleCompraController.class);
	
	private DetalleCompraServices detalleCompraServices;

	@Autowired
	public DetalleCompraController(DetalleCompraServices detalleCompraServices) {
		super();
		this.detalleCompraServices = detalleCompraServices;
	}
	
	@GetMapping(produces="application/json")
	public List<DetalleCompra> obtenerTodos(){
		try {
			return detalleCompraServices.obtenerTodos();
		} catch (DataIntegrityViolationException e) {
			logger.info("Error en el consumo del servicio obtenerTodosDetalle_Compra: " + e.getMessage());
			throw new DataIntegrityViolationException(e.getMessage());
		}
		
	}
	
	@PostMapping(produces="application/json")
	public DetalleCompra guardar(@RequestBody @Validated DetalleCompra detalleCompra) {
		try {
			return detalleCompraServices.guardar(detalleCompra);
		} catch (DataIntegrityViolationException e) {
			logger.info("Error en el consumo del servicio guardarDetalle_Compra: " + e.getMessage());
			throw new DataIntegrityViolationException(e.getMessage());
		}
	}
	
	@RequestMapping(path="/{id}", produces="application/json", method=RequestMethod.DELETE)
	public void eliminar(@PathVariable(value="id") Integer id) {
		try {
			detalleCompraServices.eliminar(id);
		} catch (DataIntegrityViolationException e) {
			logger.info("Error en el consumo del servicio eliminarDetalle_Compra: " + e.getMessage());
			throw new DataIntegrityViolationException(e.getMessage());
		}
	}
	

}
