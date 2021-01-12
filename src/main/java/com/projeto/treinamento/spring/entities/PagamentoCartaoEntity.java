package com.projeto.treinamento.spring.entities;

import javax.persistence.Entity;

import com.projeto.treinamento.spring.entities.enums.StatusPagamentoEnum;

@Entity
public final class PagamentoCartaoEntity extends PagamentoEntity {
	private static final long serialVersionUID = 1L;
	private Integer quantidadeParcelas;

	public PagamentoCartaoEntity() {
	}

	public PagamentoCartaoEntity(StatusPagamentoEnum status, PedidoEntity pedido, Integer quantidadeParcelas) {
		super(status, pedido);
		this.quantidadeParcelas = quantidadeParcelas;
	}

	public Integer getQuantidadeParcelas() {
		return quantidadeParcelas;
	}

	public void setQuantidadeParcelas(Integer quantidadeParcelas) {
		this.quantidadeParcelas = quantidadeParcelas;
	}

}
