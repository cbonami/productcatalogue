package be.vdab.demo.productcatalogue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

@SpringBootApplication
@EnableSwagger2
public class ProductServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductServiceApplication.class, args);
    }

    // Make a new Docket-bean for every other version of the API !
    // They will then appear in the Swagger UI
    @Bean
    public Docket apiV1_0() {
        return new Docket(DocumentationType.SWAGGER_2)
                //.useDefaultResponseMessages(false)
                .groupName("productcatalogue-api-1.0")
                .select()
                .apis(RequestHandlerSelectors.basePackage("be.vdab.demo.productcatalogue.resources"))
                .paths(regex("/products/v1.0.*"))
                .build()
                .apiInfo(new ApiInfoBuilder().version("1.0").title("ProductCatalogue API").description("Documentation Productcatalogue API v1.0").build());
    }

}