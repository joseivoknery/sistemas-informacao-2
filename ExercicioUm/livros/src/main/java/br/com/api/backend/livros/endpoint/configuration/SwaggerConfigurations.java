/**
 *
 */
package br.com.api.backend.livros.endpoint.configuration;

import java.util.ArrayList;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author José Ivo K. Nery
 *
 */
@Configuration
@EnableSwagger2
@Import(BeanValidatorPluginsConfiguration.class)
public class SwaggerConfigurations {

  @Bean
  public Docket api() {
    return new Docket(DocumentationType.SWAGGER_2)
        .select()
        .apis(RequestHandlerSelectors.basePackage("br.com.api.backend.livros.endpoint"))
        .paths(PathSelectors.any())
        .build().apiInfo(this.metaInfo());
  }

  private ApiInfo metaInfo() {

    @SuppressWarnings("rawtypes")
    ApiInfo apiInfo = new ApiInfo(
            "API REST Cadastro de Livros",
        "WebService de Consulta e Cadastro de Livros",
        "1.0",
        "Terms of Service",
        new Contact("José Ivo Koerich Nery", "https://https://www.linkedin.com/in/jose-ivo-koerich-nery/",
            "joseivokoerichnery@gmail.com"),
        "Apache License Version 2.0",
        "https://www.apache.org/licesen.html", new ArrayList<VendorExtension>()
        );

    return apiInfo;
  }

}
