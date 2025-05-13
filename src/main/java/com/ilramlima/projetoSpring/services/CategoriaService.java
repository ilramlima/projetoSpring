package com.ilramlima.projetoSpring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ilramlima.projetoSpring.entities.Categoria;
import com.ilramlima.projetoSpring.repository.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repository;
	
	public List<Categoria> buscarTodos(){
		
		List<Categoria> lista = repository.findAll();
		return lista;
	}
	
	public Categoria buscarPorId(Long id) {
		
		Optional<Categoria> categoria = repository.findById(id);
		
		return categoria.get();
	}
}
