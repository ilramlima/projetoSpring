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
	
	public Usuario atualizar(Long id, Usuario usuario) {
		
		Usuario pessoa = repository.getReferenceById(id);
		
		pessoa.setNome(usuario.getNome());
		pessoa.setEmail(usuario.getEmail());
		pessoa.setTelefone(usuario.getTelefone());
		
		return repository.save(pessoa);
	}
	
	public void deletarUsuario(Long id) {
		
		repository.deleteById(id);
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
		
		return usuario.get();
	}
}
