package com.projeto.treinamento.spring.entities.enums;

public enum StatusPagamentoEnum {

	PENDENTE(1, "Pendente"), QUITADO(2, "Quitado"), CANCELADO(3, "Cancelado");

	private Integer id;
	private String descricao;

	private StatusPagamentoEnum(Integer id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}

	public Integer getId() {
		return id;
	}

	public String getDescricao() {
		return descricao;
	}

	public static StatusPagamentoEnum toEnum(Integer id) {
		if (id == null) {
			return null;
		}

		for (StatusPagamentoEnum aux : StatusPagamentoEnum.values()) {
			if (aux.getId() == id) {
				return aux;
			}
		}

		throw new IllegalArgumentException(
				"Id " + id + " do enum " + StatusPagamentoEnum.class.getName() + " é inválido.");
	}
}
