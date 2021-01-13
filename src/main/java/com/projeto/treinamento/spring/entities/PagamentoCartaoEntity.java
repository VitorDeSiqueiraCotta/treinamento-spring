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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((quantidadeParcelas == null) ? 0 : quantidadeParcelas.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		PagamentoCartaoEntity other = (PagamentoCartaoEntity) obj;
		if (quantidadeParcelas == null) {
			if (other.quantidadeParcelas != null)
				return false;
		} else if (!quantidadeParcelas.equals(other.quantidadeParcelas))
			return false;
		return true;
	}

}
