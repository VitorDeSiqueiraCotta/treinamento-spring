package com.projeto.treinamento.spring.entities.enums;

public enum TipoClienteEnum {

	PESSOA_FISICA(1, "Pessoa Física"), PESSOA_JURIDICA(2, "Pessoa Jurídica");

	private Integer id;
	private String descricao;

	private TipoClienteEnum(Integer id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}

	public Integer getId() {
		return id;
	}

	public String getDescricao() {
		return descricao;
	}

	public static TipoClienteEnum toEnum(Integer id) {
		if (id == null) {
			return null;
		}

		for (TipoClienteEnum aux : TipoClienteEnum.values()) {
			if (aux.getId() == id) {
				return aux;
			}
		}

		throw new IllegalArgumentException("Id " + id + " do enum " + TipoClienteEnum.class.getName() + " é inválido.");
	}
}
