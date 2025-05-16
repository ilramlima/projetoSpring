package com.ilramlima.projetoSpring.resources;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
}
