package com.projeto.treinamento.spring.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class PedidoEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Date instance;
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "pedido")
	private PagamentoEntity pagamento;
	@ManyToOne
	@JoinColumn(name = "clienteId")
	private ClienteEntity cliente;
	@ManyToOne
	@JoinColumn(name = "enderecoDeEntregaId")
	private EnderecoEntity enderecoDeEntrega;

	public PedidoEntity() {
	}

	public PedidoEntity(Date instance, ClienteEntity cliente, EnderecoEntity enderecoDeEntrega) {
		this.instance = instance;
		this.cliente = cliente;
		this.enderecoDeEntrega = enderecoDeEntrega;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getInstance() {
		return instance;
	}

	public void setInstance(Date instance) {
		this.instance = instance;
	}

	public PagamentoEntity getPagamento() {
		return pagamento;
	}

	public void setPagamento(PagamentoEntity pagamento) {
		this.pagamento = pagamento;
	}

	public ClienteEntity getCliente() {
		return cliente;
	}

	public void setCliente(ClienteEntity cliente) {
		this.cliente = cliente;
	}

	public EnderecoEntity getEnderecoDeEntrega() {
		return enderecoDeEntrega;
	}

	public void setEnderecoDeEntrega(EnderecoEntity enderecoDeEntrega) {
		this.enderecoDeEntrega = enderecoDeEntrega;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		PedidoEntity other = (PedidoEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
