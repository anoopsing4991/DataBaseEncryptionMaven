package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SpringFoxConfig {                                    
	
	/*
	 * @Bean public Docket api() { return new
	 * Docket(DocumentationType.SWAGGER_2).select()
	 * .apis((Predicate<RequestHandler>) RequestHandlerSelectors.any())
	 * .paths((Predicate<String>) PathSelectors.any()).build(); }
	 */
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.example.demo.controller"))
				.paths(PathSelectors.any()).build();
	}
	
	/*
	 * @Bean public Docket postsApi() { return new
	 * Docket(DocumentationType.SWAGGER_2).groupName("public-api")
	 * .apiInfo(apiInfo()).select().paths(postPaths()).build(); }
	 * 
	 * private Predicate<String> postPaths() { return or(regex("/api/posts.*"),
	 * regex("/api/javainuse.*")); }
	 * 
	 * private ApiInfo apiInfo() { return new
	 * ApiInfoBuilder().title("JavaInUse API")
	 * .description("JavaInUse API reference for developers")
	 * .termsOfServiceUrl("http://javainuse.com")
	 * .contact("javainuse@gmail.com").license("JavaInUse License")
	 * .licenseUrl("javainuse@gmail.com").version("1.0").build();
	 * 
	 * }
	 */
}