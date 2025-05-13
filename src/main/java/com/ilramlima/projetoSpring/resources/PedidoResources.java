package com.ilramlima.projetoSpring.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ilramlima.projetoSpring.entities.Pedido;
import com.ilramlima.projetoSpring.services.PedidoService;

@Controller
@RequestMapping("/pedidos")
public class PedidoResources {
	
	@Autowired
	private PedidoService service;
	
	
	@GetMapping
	public ResponseEntity<List<Pedido>> buscarTodos(){
		
		List<Pedido> lista = service.buscarTodos();
		
		return ResponseEntity.ok().body(lista);
	}
	
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Pedido> buscarPorID(@PathVariable long id){
		
		Pedido pedido = service.buscarPorId(id);
		
		return ResponseEntity.ok().body(pedido);
	}
}
