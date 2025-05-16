package com.ilramlima.projetoSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ilramlima.projetoSpring.entities.ItemDoPedido;
import com.ilramlima.projetoSpring.entities.pk.ItemDoPedidoPK;

@Repository
public interface ItemDoPedidoRepository extends JpaRepository<ItemDoPedido, ItemDoPedidoPK>{

}
