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

import com.tienda.online.modelo.Rol;
import com.tienda.online.services.RolServices;


@RestController
@RequestMapping("/rol")
public class RolController {
	private static final Logger logger=org.slf4j.LoggerFactory.getLogger(RolController.class);
	
	private RolServices rolServices;
	
	@Autowired
	public RolController(RolServices rolServices) {
		super();
		this.rolServices = rolServices;
	}
	
	@PostMapping(produces="application/json")
	public Rol guardar(@RequestBody @Validated Rol rol) {
		try {
			return rolServices.guardar(rol);
		} catch (DataIntegrityViolationException e) {
			logger.info("Error en el consumo del servicio guardarRol "+ e.getMessage());// TODO: handle exception
			throw new DataIntegrityViolationException(e.getMessage());
		}
	}
	
	@GetMapping(produces="application/json")
	public List<Rol> obtenerTodos() {
		try {
			return rolServices.obtenerTodos();
		} catch (DataIntegrityViolationException e) {
			logger.info("Error en el consumo del servicio obtenerRol "+ e.getMessage());// TODO: handle exception
			throw new DataIntegrityViolationException(e.getMessage());
		}
	}
	
	@PutMapping(produces="application/json")
	public Rol actualizar(@RequestBody @Validated Rol rol) {
		try {
			return rolServices.guardar(rol);
		} catch (DataIntegrityViolationException e) {
			logger.info("Error en el consumo del servicio actualizarRol "+ e.getMessage());// TODO: handle exception
			throw new DataIntegrityViolationException(e.getMessage());
		}
	}
	
	@RequestMapping(path="/{codigo}", produces="application/json", method= RequestMethod.DELETE)
	public void eliminar(@PathVariable (value="id") Integer id) {
		try {
			rolServices.eliminar(id);
		} catch (DataIntegrityViolationException e) {
			logger.info("Error en el consumo del servicio eliminarRol "+ e.getMessage());// TODO: handle exception
			throw new DataIntegrityViolationException(e.getMessage());
		}
	}
	
}
