package com.projeto.treinamento.spring.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.treinamento.spring.entities.PedidoEntity;
import com.projeto.treinamento.spring.exceptions.ObjectNotFoundException;
import com.projeto.treinamento.spring.repositories.PedidoRepository;

@Service
public class PedidoService {
	@Autowired
	PedidoRepository pedidoRepository;
	
	public PedidoEntity findPedido(Integer id) {
		Optional<PedidoEntity> obj = pedidoRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + obj.getClass().getName()));
	}
}
