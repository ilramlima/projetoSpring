package com.ilramlima.projetoSpring.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ilramlima.projetoSpring.entities.Produto;
import com.ilramlima.projetoSpring.services.ProdutoService;

@RestController
@RequestMapping("/produtos")
public class ProdutoResources {
	
	@Autowired
	private ProdutoService service;
	
	@GetMapping
	public ResponseEntity<List<Produto>> buscarTodos(){
		
		List<Produto> produtos = service.buscarTodos();
		
		return ResponseEntity.ok().body(produtos);
	}
	
	@GetMapping(value = "/{id}")
	private ResponseEntity<Produto> buscarPorId(@PathVariable Long id) {
		
		Produto produto = service.buscarPorId(id);
		
		return ResponseEntity.ok().body(produto);
	}
}
