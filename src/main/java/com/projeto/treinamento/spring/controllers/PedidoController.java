package com.projeto.treinamento.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.projeto.treinamento.spring.entities.PedidoEntity;
import com.projeto.treinamento.spring.services.PedidoService;

@Controller
@RequestMapping(value = "/pedidos")
public class PedidoController {

	@Autowired
	private PedidoService pedidoService;

	@GetMapping(value = "/{id}")
	public ResponseEntity<PedidoEntity> find(@PathVariable Integer id ) {
		PedidoEntity obj = pedidoService.findPedido(id);
		return ResponseEntity.ok().body(obj);
	}

}
