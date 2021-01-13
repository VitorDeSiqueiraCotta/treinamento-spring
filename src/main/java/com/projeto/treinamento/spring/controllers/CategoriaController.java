package com.projeto.treinamento.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.treinamento.spring.entities.CategoriaEntity;
import com.projeto.treinamento.spring.services.CategoriaService;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaController {

	@Autowired
	private CategoriaService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<CategoriaEntity> listar(@PathVariable Integer id) {
		CategoriaEntity obj = service.getCategoria(id);
		return ResponseEntity.ok().body(obj);
	}
}
