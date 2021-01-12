package com.projeto.treinamento.spring.entities;

import java.util.Date;

import javax.persistence.Entity;

import com.projeto.treinamento.spring.entities.enums.StatusPagamentoEnum;

@Entity
public final class PagamentoBoletoEntity extends PagamentoEntity {
	private static final long serialVersionUID = 1L;
	private Date dataVencimento;
	private Date dataPagamento;

	public PagamentoBoletoEntity() {
	}

	public PagamentoBoletoEntity(StatusPagamentoEnum status, PedidoEntity pedido, Date dataVencimento,
			Date dataPagamento) {
		super(status, pedido);
		this.dataVencimento = dataVencimento;
		this.dataPagamento = dataPagamento;
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

}