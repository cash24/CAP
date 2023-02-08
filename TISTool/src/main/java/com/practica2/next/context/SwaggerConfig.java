package com.practica2.next.context;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
//Swagger configuration
public class SwaggerConfig {


 //Contact
 public static final Contact DEFAULT_CONTACT = new Contact("OUI", "http://www.dominio.com"
   ,"soporte@dominio.com");
 
 //info Application 
 public static final ApiInfo DEFAULT_API_INFO = new ApiInfo("Project - Documentation"
   , "Project - Documentatio ", "1.0","PREMIUM", DEFAULT_CONTACT, "Apache 2.0"
   , "http://www.apache.org/licenses/LICENSE-2.0",new ArrayList<>());
 //Api Method
 @Bean
 public Docket api() {
  //Generate swagger instance
  return new Docket(DocumentationType.SWAGGER_2).apiInfo(DEFAULT_API_INFO);
 }
}
