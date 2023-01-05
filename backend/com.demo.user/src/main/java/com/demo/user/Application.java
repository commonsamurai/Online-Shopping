package com.demo.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;


//@SpringBootApplication
@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
//@EnableSwagger2
@OpenAPIDefinition(info=@Info(title="User API" , version = "2.0", description = "User Microservice"))
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	/*@Bean
	public Docket userApi() {
		 return new Docket(DocumentationType.SWAGGER_2).select()
				 .apis(RequestHandlerSelectors.basePackage("com.demo.user")).build();
		 
		 
	} */
}
