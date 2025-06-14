package com.ilramlima.projetoSpring.resources;


import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ilramlima.projetoSpring.entities.Usuario;
import com.ilramlima.projetoSpring.services.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioResources {

	@Autowired
	private UsuarioService service;
	
	
	@GetMapping
	public ResponseEntity<List<Usuario>> buscarTodos(){
		
		List<Usuario> usuarios = service.buscarTodos();
		
		return ResponseEntity.ok().body(usuarios);
		
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Usuario> buscarPorId(@PathVariable long id) {
		
		Usuario usuario = service.buscarPorId(id);
		
		return ResponseEntity.ok().body(usuario);
	}
	
	@PostMapping
	public ResponseEntity<Usuario> salvarUsuario(@RequestBody Usuario usuario) {
		
		usuario = service.inserirUsuario(usuario);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(usuario.getId()).toUri();
		
		return ResponseEntity.created(uri).body(usuario);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deletarUsuario(@PathVariable Long id){
		
		service.deletarUsuario(id);
		
		return ResponseEntity.noContent().build();
		
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Usuario> atualizarUsuario(@PathVariable Long id, @RequestBody Usuario usuario){
		
		usuario = service.atualizar(id, usuario);
		
		return ResponseEntity.ok().body(usuario);
	}
}
