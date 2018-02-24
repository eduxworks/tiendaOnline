package com.tienda.online.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tienda.online.modelo.DetalleCompra;
import com.tienda.online.repositories.DetalleCompraRepository;

@Service
public class DetalleCompraServices {
	
	private DetalleCompraRepository detalleCompraRepository;
	
	@Autowired
	public DetalleCompraServices(DetalleCompraRepository detalleCompraRepository) {
		super();
		this.detalleCompraRepository = detalleCompraRepository;
	}
	
	public DetalleCompra guardar(DetalleCompra detallecompra) {
		return detalleCompraRepository.save(detallecompra);
	}
	
	public void eliminar(Integer id) {
		detalleCompraRepository.delete(id);
	}
	
	public List<DetalleCompra> obtenerTodos() {
		return (List<DetalleCompra>) detalleCompraRepository.findAll();
	}
}
