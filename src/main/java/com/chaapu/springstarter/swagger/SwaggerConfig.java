package com.chaapu.springstarter.swagger;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Optional;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .host("localhost:3000")
                .useDefaultResponseMessages(false)
                .apiInfo(metaData())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(Predicates.not(PathSelectors.regex("/error.*")))
                .build()
                .genericModelSubstitutes(Optional.class); // for optional query parameters

    }

    private ApiInfo metaData() {
        return new ApiInfoBuilder()
                .title("BANK API")
                .description("API to compliment the REST API Testing Training")
                .termsOfServiceUrl("www.anz.co.nz")
                .contact(new Contact("Mandakini Mishra", "https://github.com/message2prateek", "Mandakini.Mishra@anz.co.nz"))
                .license("Apache License Version 2.0")
                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
                .version("2.0")
                .build();
    }
}
