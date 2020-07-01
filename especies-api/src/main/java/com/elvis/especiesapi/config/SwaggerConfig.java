package com.elvis.especiesapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;

@Component
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {

        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors
                        .basePackage("com.elvis.especiesapi.controladores"))
                .paths(PathSelectors.any())
                .build().apiInfo(apiEndPointsInfo()).securitySchemes(Arrays.asList(apiKey()));
    }

    private ApiInfo apiEndPointsInfo() {

        return new ApiInfoBuilder().title("API REST ESPECIES ")
                .description("Permite mantener el catalogo de especies dentro de la aplicacion clinica de mascotas")
                .contact(new Contact("Carlos Mendoza", "http://blog.reinventarlarueda.com", "ismaelviss@gmail.com"))
                .license("Apache 2.0")
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
                .version("1.0-SNAPSHOT")
                .build();
    }

    private ApiKey apiKey() {
        return new ApiKey("apiKey", "Authorization", "header"); //`apiKey` is the name of the APIKey, `Authorization` is the key in the request header
    }
}
