package com.projeto.treinamento.spring;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.projeto.treinamento.spring.entities.CategoriaEntity;
import com.projeto.treinamento.spring.entities.CidadeEntity;
import com.projeto.treinamento.spring.entities.ClienteEntity;
import com.projeto.treinamento.spring.entities.EnderecoEntity;
import com.projeto.treinamento.spring.entities.EstadoEntity;
import com.projeto.treinamento.spring.entities.PagamentoBoletoEntity;
import com.projeto.treinamento.spring.entities.PagamentoCartaoEntity;
import com.projeto.treinamento.spring.entities.PagamentoEntity;
import com.projeto.treinamento.spring.entities.PedidoEntity;
import com.projeto.treinamento.spring.entities.ProdutoEntity;
import com.projeto.treinamento.spring.entities.enums.StatusPagamentoEnum;
import com.projeto.treinamento.spring.entities.enums.TipoClienteEnum;
import com.projeto.treinamento.spring.repositories.CategoriaRepository;
import com.projeto.treinamento.spring.repositories.CidadeRepository;
import com.projeto.treinamento.spring.repositories.ClienteRepository;
import com.projeto.treinamento.spring.repositories.EnderecoRepository;
import com.projeto.treinamento.spring.repositories.EstadoRepository;
import com.projeto.treinamento.spring.repositories.PagamentoRepository;
import com.projeto.treinamento.spring.repositories.PedidoRepository;
import com.projeto.treinamento.spring.repositories.ProdutoRepository;

@SpringBootApplication
public class MainApplication implements CommandLineRunner {
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private PagamentoRepository pagamentoRepository;
	@Autowired
	private PedidoRepository pedidoRepository;

	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		CategoriaEntity cat1 = new CategoriaEntity("Informática");
		CategoriaEntity cat2 = new CategoriaEntity("Escritório");

		ProdutoEntity p1 = new ProdutoEntity("Computador", 2000.0);
		ProdutoEntity p2 = new ProdutoEntity("Impressora", 800.0);
		ProdutoEntity p3 = new ProdutoEntity("Mouse", 80.0);

		cat1.getListaProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getListaProdutos().addAll(Arrays.asList(p2));

		p1.getListaCategorias().addAll(Arrays.asList(cat1));
		p2.getListaCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getListaCategorias().addAll(Arrays.asList(cat1));

		EstadoEntity est1 = new EstadoEntity("Minas Gerais");
		EstadoEntity est2 = new EstadoEntity("São Paulo");

		CidadeEntity c1 = new CidadeEntity("Uberlândia", est1);
		CidadeEntity c2 = new CidadeEntity("São Paulo", est2);
		CidadeEntity c3 = new CidadeEntity("Campinas", est2);

		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2, c3));

		ClienteEntity cli1 = new ClienteEntity("Maria Silva", "maria@gmail.com", "24558871660",
				TipoClienteEnum.PESSOA_FISICA);
		cli1.getTelefones().addAll(Arrays.asList("31 9 9465 0469", "35 8 9866 3411"));

		EnderecoEntity e1 = new EnderecoEntity("Rua Flores", "300", "Apt 303", "Jardim", "38220834", cli1, c1);
		EnderecoEntity e2 = new EnderecoEntity("Avenida Matos", "105", "Sala 800", "Centro", "3877012", cli1, c2);

		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));

		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy HH:mm");

		PedidoEntity ped1 = new PedidoEntity(sdf.parse("30/09/2017 10:32"), cli1, e1);
		PedidoEntity ped2 = new PedidoEntity(sdf.parse("10/10/2017 19:35"), cli1, e2);

		PagamentoEntity pag1 = new PagamentoCartaoEntity(StatusPagamentoEnum.QUITADO, ped1, 6);
		ped1.setPagamento(pag1);
		PagamentoEntity pag2 = new PagamentoBoletoEntity(StatusPagamentoEnum.PENDENTE, ped2,
				sdf.parse("20/10/2017 00:00:00"), null);
		ped2.setPagamento(pag2);

		cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));

		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1, e2));
		pedidoRepository.saveAll(Arrays.asList(ped1, ped2));
		pagamentoRepository.saveAll(Arrays.asList(pag1, pag2));

	}
}
