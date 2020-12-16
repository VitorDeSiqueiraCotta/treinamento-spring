package com.projeto.treinamento.spring;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.projeto.treinamento.spring.entities.CategoriaEntity;
import com.projeto.treinamento.spring.entities.ProdutoEntity;
import com.projeto.treinamento.spring.repositories.CategoriaRepository;
import com.projeto.treinamento.spring.repositories.ProdutoRepository;

@SpringBootApplication
public class MainApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private ProdutoRepository produtoRepository;

	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		CategoriaEntity cat1 = new CategoriaEntity(null, "Informática");
		CategoriaEntity cat2 = new CategoriaEntity(null, "Escritório");

		ProdutoEntity p1 = new ProdutoEntity(null, "Computador", 2000.0);
		ProdutoEntity p2 = new ProdutoEntity(null, "Impressora", 800.0);
		ProdutoEntity p3 = new ProdutoEntity(null, "Mouse", 80.0);

		cat1.getListaProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getListaProdutos().addAll(Arrays.asList(p2));

		p1.getListaCategorias().addAll(Arrays.asList(cat1));
		p2.getListaCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getListaCategorias().addAll(Arrays.asList(cat1));

		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
	}
}
