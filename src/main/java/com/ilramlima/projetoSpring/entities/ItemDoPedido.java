package com.ilramlima.projetoSpring.entities;

import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ilramlima.projetoSpring.entities.pk.ItemDoPedidoPK;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_item_do_pedido")
public class ItemDoPedido implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private ItemDoPedidoPK id = new ItemDoPedidoPK();
	
	private Integer quantidade;
	private Double preco;
	
	public ItemDoPedido() {}
	
	public ItemDoPedido(Pedido pedido, Produto produto, Integer quantidade, Double preco) {
		
		id.setPedido(pedido);
		id.setProduto(produto);
		this.quantidade = quantidade;
		this.preco = preco;
	}
	
	
	public Double getSubTotal() {
		
		return preco * quantidade;
	}

	@JsonIgnore
	public Pedido getPedido() {
		
		return id.getPedido();
	}
	
	public void setPedido(Pedido pedido) {
		
		id.setPedido(pedido);
	}
	
	
	public Produto getProduto() {
		
		return id.getProduto();
	}
	
	public void setProduto(Produto produto) {
		
		id.setProduto(produto);
	}
		
	
	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemDoPedido other = (ItemDoPedido) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
}
