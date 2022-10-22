package com.bookmyturf.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
@EnableWebMvc
public class ResourceWebConfig implements WebMvcConfigurer{
	
	private Logger log = LoggerFactory.getLogger(ResourceWebConfig.class);
	
	public ResourceWebConfig() {
		log.info("ResourceWebConfig() invoked!!");
	}

	@Override
	public void addResourceHandlers(final ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/api/swagger-ui.html**").addResourceLocations("classpath:/META-INF/resources/swagger-ui.html");
		registry.addResourceHandler("/api/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addRedirectViewController("/api/v2/api-docs", "/v2/api-docs");
		registry.addRedirectViewController("/api/swagger-resources/configuration/ui", "/swagger-resources/configuration/ui");
		registry.addRedirectViewController("/api/swagger-resources/configuration/security", "/swagger-resources/configuration/security");
		registry.addRedirectViewController("/api/swagger-resources", "/swagger-resources");
	}
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.bookmyturf"))
				.paths(PathSelectors.regex("/.*"))
				.build().apiInfo(apiInfoMetaData());
	}

	private ApiInfo apiInfoMetaData() {
		return new ApiInfoBuilder().title("BookMyTurf Services")
				.description("API Endpoints")
				.contact(new Contact("Ravi", "http://localhost:8080", "ravi.balsuni26@gmail.com"))
				.license("Apache 2.0")
				.version("1.0.0")
				.build();
	}
	
	
}
