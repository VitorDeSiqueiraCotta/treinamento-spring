package com.projeto.treinamento.spring.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.treinamento.spring.entities.ClienteEntity;
import com.projeto.treinamento.spring.exceptions.ObjectNotFoundException;
import com.projeto.treinamento.spring.repositories.ClienteRepository;

@Service
public class ClienteService {
	@Autowired
	ClienteRepository clienteRepository;

	public ClienteEntity getCliente(Integer id) {
		Optional<ClienteEntity> obj = clienteRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + obj.getClass().getName()));
	}

}
