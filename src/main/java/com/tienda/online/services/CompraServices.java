package com.tienda.online.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tienda.online.modelo.Compra;
import com.tienda.online.repositories.CompraRepository;

@Service
public class CompraServices {
	
	private CompraRepository compraRepository;
	
	@Autowired
	public CompraServices(CompraRepository compraRepository) {
		super();
		this.compraRepository = compraRepository;
	}
	
	public Compra guardar(Compra compra) {
		compra.setFecha(new Date());
		compra.setNroDocumento("0000000"+compraRepository.count()+1);
		compra.getListaDetalleCompra().forEach(detalle ->{detalle.setCompra(compra);});
		return compraRepository.save(compra);
	}
	
	public void eliminar(Integer id) {
		compraRepository.delete(id);
	}
	
	public List<Compra> obtenerTodos() {
		return (List<Compra>) compraRepository.findAll();
	}
	
}
