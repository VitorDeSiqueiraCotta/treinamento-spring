package com.projeto.treinamento.spring.entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class ItemPedidoEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	@EmbeddedId
	private ItemPedidoPkEntity id = new ItemPedidoPkEntity();
	private Double desconto;
	private Double preco;
	private Integer quantidade;

	public ItemPedidoEntity() {
	}

	public ItemPedidoEntity(PedidoEntity pedido, ProdutoEntity produto, Double desconto, Double preco,
			Integer quantidade) {
		this.id = new ItemPedidoPkEntity(pedido, produto);
		this.desconto = desconto;
		this.preco = preco;
		this.quantidade = quantidade;
	}

	public ItemPedidoPkEntity getId() {
		return id;
	}

	public void setId(ItemPedidoPkEntity id) {
		this.id = id;
	}

	public PedidoEntity getPedido() {
		return id.getPedido();
	}

	public ProdutoEntity getProduto() {
		return id.getProduto();
	}

	public Double getDesconto() {
		return desconto;
	}

	public void setDesconto(Double desconto) {
		this.desconto = desconto;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((desconto == null) ? 0 : desconto.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((preco == null) ? 0 : preco.hashCode());
		result = prime * result + ((quantidade == null) ? 0 : quantidade.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemPedidoEntity other = (ItemPedidoEntity) obj;
		if (desconto == null) {
			if (other.desconto != null)
				return false;
		} else if (!desconto.equals(other.desconto))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (preco == null) {
			if (other.preco != null)
				return false;
		} else if (!preco.equals(other.preco))
			return false;
		if (quantidade == null) {
			if (other.quantidade != null)
				return false;
		} else if (!quantidade.equals(other.quantidade))
			return false;
		return true;
	}

}
