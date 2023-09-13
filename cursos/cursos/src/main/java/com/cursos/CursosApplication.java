package com.cursos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class CursosApplication {

	public static void main(String[] args) {
		SpringApplication.run(CursosApplication.class, args);
	}

}

//@RestController
//class HttpController{
	//@GetMapping("/pessoas/create")
	//String publicRoute(){
		//return "<h1>REGISTRO DE PESSOA</h1>";
	//}
//}
