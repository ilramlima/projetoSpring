package com.ilramlima.projetoSpring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ilramlima.projetoSpring.entities.Usuario;
import com.ilramlima.projetoSpring.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;
	
	
	public List<Usuario> buscarTodos(){
		
		List<Usuario> lista = repository.findAll();
		
		return lista;
	}
	
	
	public Usuario buscarPorId(Long id) {
		
		Optional<Usuario> usuario = repository.findById(id);
		
		return usuario.get();
	}
}
