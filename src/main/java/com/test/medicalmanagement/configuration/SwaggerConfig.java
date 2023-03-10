package com.test.medicalmanagement.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig extends WebMvcConfigurationSupport {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage("com.test.medicalmanagement")).paths(PathSelectors.any())
                .build()
                .tags(new Tag("Medical Management MS", "Medical Management MS Endpoints"))
                .apiInfo(metaData());
    }

    private ApiInfo metaData() {
        return new ApiInfoBuilder().title("Medical Management MS")
                .description("Responsible for Medical Management").version("1.0.0")
                .contact(new Contact("Mirzazada Allahshukur", "",
                        "alik.mirzazada@gmail.com"))
                .license("Apache License Version 2.0").licenseUrl("https://www.apache.org/licenses/LICENSE-2.0\"")
                .build();

    }

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
    }


}
