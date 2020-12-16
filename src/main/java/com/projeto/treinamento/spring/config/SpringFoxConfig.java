package com.projeto.treinamento.spring.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SpringFoxConfig {
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.projeto.treinamento.spring")).paths(PathSelectors.any())
				.build().apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {
		return new ApiInfo("Treinamento Spring API", "Treinamento Spring API.", "0.0.1", "Terms of service", contact(),
				"Licença MIT", "https://github.com/VitorDeSiqueiraCotta/treinamento-spring/blob/master/LICENSE",
				Collections.emptyList());
	}

	private Contact contact() {
		return new Contact("Vitor de Siqueira Cotta", "https://github.com/VitorDeSiqueiraCotta/treinamento-spring",
				"vitorsiqueira95@outlook.com");
	}
}