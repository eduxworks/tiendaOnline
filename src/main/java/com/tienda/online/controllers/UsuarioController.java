package com.tienda.online.controllers;

import java.util.List;
import java.util.NoSuchElementException;

import org.hibernate.hql.internal.ast.ErrorReporter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tienda.online.modelo.Usuario;
import com.tienda.online.modelo.dto.response.ErrorResponse;
import com.tienda.online.services.UsuarioServices;



@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	private static Logger logger = LoggerFactory.getLogger(UsuarioController.class);
	
	private UsuarioServices usuarioServices;

	@Autowired
	public UsuarioController(UsuarioServices usuarioServices) {
		super();
		this.usuarioServices = usuarioServices;
	}
	
	@PostMapping(produces="application/json")
	public Usuario guardar(@RequestBody @Validated Usuario usuario) {
		try
		{	
			Usuario nuevoUsuario = usuarioServices.guardar(usuario);
			if(nuevoUsuario==null) {
				throw new DataIntegrityViolationException("Ya existe usuario con el email:" + usuario.getEmail());
			}
			return nuevoUsuario;
		}catch(NoSuchElementException e) {
			logger.info("Error en el consumo del servicio guardarUsuario: " + e.getMessage());
			throw new NoSuchElementException("Error en el consumo del servicio guardar Ususario"+e.getMessage());
		}
	}
	
	@GetMapping(produces="application/json")
	public List<Usuario> obtenerTodos(){
		try {	
				return usuarioServices.obtenerTodos();
		} catch (DataIntegrityViolationException e) {
			logger.info("Error en el consumo del servicio obtenerTodosUsuario: " + e.getMessage());
			throw new DataIntegrityViolationException(e.getMessage());
		}
	}
	
	@RequestMapping(path="/{id}", produces="application/json", method= RequestMethod.DELETE)
	public void eliminar(Integer id) {
		try {
			usuarioServices.eliminar(id);
		} catch (DataIntegrityViolationException e) {
			logger.info("Error en el consumo del servicio eliminarUsuario: " + e.getMessage());
			throw new DataIntegrityViolationException(e.getMessage());
		}
	}
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(NoSuchElementException.class)
	public ErrorResponse return404(NoSuchElementException ex) {
		return new ErrorResponse(ex.getMessage(),
				HttpStatus.NOT_FOUND.value());
	}
	
	@ResponseStatus(HttpStatus.CONFLICT)
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ErrorResponse return409(DataIntegrityViolationException ex) {
		return new ErrorResponse(ex.getMessage(),
				HttpStatus.CONFLICT.value());
	}
	
}
