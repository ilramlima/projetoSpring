package com.ilramlima.projetoSpring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.ilramlima.projetoSpring.entities.Usuario;
import com.ilramlima.projetoSpring.repository.UsuarioRepository;
import com.ilramlima.projetoSpring.services.exceptions.DatabaseException;
import com.ilramlima.projetoSpring.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;
	
	public Usuario atualizar(Long id, Usuario usuario) {
		
		Usuario pessoa = repository.getReferenceById(id);
		
		try {
			
			pessoa.setNome(usuario.getNome());
			pessoa.setEmail(usuario.getEmail());
			pessoa.setTelefone(usuario.getTelefone());
			
			return repository.save(pessoa);
			
		} catch (EntityNotFoundException e) {
			
			throw new ResourceNotFoundException(id);
		}
	}
	
	public void deletarUsuario(Long id) {
		
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
		
	}
	
	public Usuario inserirUsuario(Usuario usuario) {
		
		return repository.save(usuario);
	}
	
	public List<Usuario> buscarTodos(){
		
		List<Usuario> lista = repository.findAll();
		
		return lista;
	}
	
	
	public Usuario buscarPorId(Long id) {
		
		Optional<Usuario> usuario = repository.findById(id);
		
		return usuario.orElseThrow(() -> new ResourceNotFoundException(id));
	}
}
