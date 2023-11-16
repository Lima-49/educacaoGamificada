package com.project.educacaogamificada;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
public class EducacaoGamificadaApplication {

	public static void main(String[] args) {
		SpringApplication.run(EducacaoGamificadaApplication.class, args);
	}

}
