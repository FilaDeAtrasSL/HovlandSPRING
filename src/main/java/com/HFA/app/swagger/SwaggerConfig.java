package com.HFA.app.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;



@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
                return new Docket(DocumentationType.SWAGGER_2).
                		apiInfo(apiInfo()).
                		select().
                		apis(RequestHandlerSelectors.basePackage("com.HFA.app.controlador")).
                		paths(PathSelectors.any()).
                		build();
        }
    
    private ApiInfo apiInfo() {
    	return new ApiInfoBuilder().title("Drogas Hovland API")
    			.description("La mejor API de Hovland de toda la red")
    			.termsOfServiceUrl("https://youtu.be/dQw4w9WgXcQ")
    			.license("Hovland License")
    			.licenseUrl("https://youtu.be/-B9JqJFVzGQ").version("1.0").
    			build();
    			
    }
    
}


