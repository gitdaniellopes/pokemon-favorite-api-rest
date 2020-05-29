package br.com.daniellopes.pokemonfavoriteapi.swagger;

import br.com.daniellopes.pokemonfavoriteapi.model.Pokemon;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket pokemonApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("br.com.daniellopes.pokemonfavoriteapi"))
                .paths(PathSelectors.ant("/**"))
                .build()
                .apiInfo(metaInfo())
                .ignoredParameterTypes(Pokemon.class);
    }

    private ApiInfo metaInfo() {
        return new ApiInfo(
                "Pokemon - favoritos API REST",
                "API REST dos meus pokemons favoritos.",
                "1.0",
                "Terms of Service",
                new Contact("Daniel Lopes", null,
                        "danieljfsantos@gmail.com"),
                "Apache License Version 2.0",
                "https://www.apache.org/licesen.html", new ArrayList<>()

        );
    }

}
