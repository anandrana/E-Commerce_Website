package com.ecommerce.website.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
@EnableWebMvc
//@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.ecommerce.website.controller"))
				.paths(PathSelectors.regex("/.*"))
				.build().apiInfo(metadata());
	}

	private ApiInfo metadata() {
		return new ApiInfoBuilder()
				.title("Ecommerce Website")
				.description("Ecommerce Website for learning purpose")
				.version("1.1.0")
				.license("Apache 2.0")
				.licenseUrl("https://www.apache.org/licenses/LICENSE-2.0.html")
				.contact(new Contact("Ecommerce Website ","https://youtube.com","ranaanand1162@gmail.com"))
				.build();
	}
}
