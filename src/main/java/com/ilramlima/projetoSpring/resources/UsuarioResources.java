package com.ilramlima.projetoSpring.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ilramlima.projetoSpring.entities.Usuario;

@RestController
@RequestMapping("/usuarios")
public class UsuarioResources {

	@GetMapping
	public ResponseEntity<List<Usuario>> findAll(){
		
		List<Usuario> list = new ArrayList<>();
		
		list.add(new Usuario(1L, "Maria", "maria@email.com", "73987654321", "12345"));
		list.add(new Usuario(1L, "João", "joao@email.com", "73987654321", "12345"));
		
		return ResponseEntity.ok().body(list);
		
	}
}
