package com.projeto.treinamento.spring.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.treinamento.spring.entities.CategoriaEntity;
import com.projeto.treinamento.spring.repositories.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repo;
	
	public CategoriaEntity getCategoria(Integer id) {
		Optional<CategoriaEntity> obj = repo.findById(id);
		return obj.orElse(null); 
	}
	
}
