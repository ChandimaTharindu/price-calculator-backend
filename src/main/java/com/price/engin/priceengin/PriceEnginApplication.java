package com.price.engin.priceengin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class PriceEnginApplication {

	public static void main(String[] args) {
		SpringApplication.run(PriceEnginApplication.class, args);
	}

}
