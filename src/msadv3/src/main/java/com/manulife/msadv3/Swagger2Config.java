package com.manulife.msadv3;

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

@Configuration
@EnableSwagger2
public class Swagger2Config {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(currentApiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.manulife.msadv3.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo currentApiInfo() {
        return new ApiInfoBuilder()
                .title("SpringBoot User Service APIs")
                .description("Find more details : http://edisonchou.cnblogs.com")
                .termsOfServiceUrl("http://edisonchou.cnblogs.com")
                .contact(new Contact("Edison Zhou",
                        "http://edisonchou.cnblogs.com",
                        "http://edison_x_zhou@manulife.com"))
                .version("1.0")
                .build();
    }
}
