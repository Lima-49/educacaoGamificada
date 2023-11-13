package com.project.educacaogamificada;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Controller
@SpringBootApplication
public class EducacaoGamificadaApplication {

	public static void main(String[] args) {
		SpringApplication.run(EducacaoGamificadaApplication.class, args);
	}

}
