package com.ilramlima.projetoSpring.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ilramlima.projetoSpring.entities.enums.StatusPedido;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_pedido")
public class Pedido implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant dataPedido;
	
	private Integer statusDoPedido;
	
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Usuario cliente;

	@OneToMany(mappedBy = "id.pedido")
	private Set<ItemDoPedido> itens = new HashSet<>();
	
	public Pedido() {};
	
	public Pedido(Long id, Instant dataPedido, StatusPedido statusDoPedido, Usuario cliente) {
		
		this.id = id;
		this.dataPedido = dataPedido;
		setStatusDoPedido(statusDoPedido);
		this.cliente = cliente;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(Instant dataPedido) {
		this.dataPedido = dataPedido;
	}
	
	public StatusPedido getStatusDoPedido() {
		return StatusPedido.valueOf(this.statusDoPedido);
	}
	
	public void setStatusDoPedido(StatusPedido statusDoPedido) {
		this.statusDoPedido = statusDoPedido.getCode();
	}

	public Usuario getCliente() {
		return cliente;
	}

	public void setCliente(Usuario cliente) {
		this.cliente = cliente;
	}

	public Set<ItemDoPedido> getItens(){
		return itens;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(cliente);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		return Objects.equals(cliente, other.cliente);
	}
	
	
	
	
	
}
