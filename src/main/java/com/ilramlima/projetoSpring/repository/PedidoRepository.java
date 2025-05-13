package com.ilramlima.projetoSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ilramlima.projetoSpring.entities.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long>{
	
}
