package com.ilramlima.projetoSpring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ilramlima.projetoSpring.entities.Produto;
import com.ilramlima.projetoSpring.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository repository;
	
	
	public List<Produto> buscarTodos(){
		
		List<Produto> produtos = repository.findAll();
		
		return produtos;
	}
	
	public Produto buscarPorId(Long id) {
		
		Optional<Produto> produto = repository.findById(id);
		
		return produto.get();
	}
}
