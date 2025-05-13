package com.ilramlima.projetoSpring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.ilramlima.projetoSpring.entities.Pedido;
import com.ilramlima.projetoSpring.repository.PedidoRepository;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repository;
	
	
	public List<Pedido> buscarTodos(){
		
		List<Pedido> list = repository.findAll();
		
		return list;
	}
	
	
	public Pedido buscarPorId(Long id) {
		
		Optional<Pedido> pedido = repository.findById(id);
		
		return pedido.get();		
		
	}
}
