package com.cursos;

import com.cursos.modulos.curso.DAO.AppDAO;
import com.cursos.modulos.curso.Pessoa.Pessoa;
import com.cursos.modulos.curso.Roles.Roles;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class CursosApplication {

	public static void main(String[] args) {
		SpringApplication.run(CursosApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO){

		return runner ->{
			cadastrarPessoa(appDAO);
		};
	}

	private void cadastrarPessoa(AppDAO appDAO) {
		Pessoa tempPessoa =
				new Pessoa("Marilu", "78945612332", "Marilu Campos", "47655243977", "marilu@gmail.com",
				"F", "1964-03-05","67028430","Flores", "Limoeiro", "Rio de Janeiro", "RJ","84",
				"{bcrypt}$2a$10$6CIrQ1mOGj3wxyDhB6zbhuJaR3jztI2nQ.ItZWmIvW5eDvUvQiXs6", 1);

		Roles tempRoles =
				new Roles("ROLE_ADMIN");

		tempPessoa.setRoles(tempRoles);
		System.out.println("Salvando pesssoa" + tempPessoa);
		appDAO.save(tempPessoa);

		System.out.println("feito!");
	}

}

//@RestController
//class HttpController{
	//@GetMapping("/pessoas/create")
	//String publicRoute(){
		//return "<h1>REGISTRO DE PESSOA</h1>";
	//}
//}
