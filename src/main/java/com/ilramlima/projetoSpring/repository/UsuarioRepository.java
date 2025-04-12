package com.ilramlima.projetoSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ilramlima.projetoSpring.entities.Usuario;



@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	

}
