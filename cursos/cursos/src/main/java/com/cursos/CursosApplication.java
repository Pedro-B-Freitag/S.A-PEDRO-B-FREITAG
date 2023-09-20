package com.cursos;

import com.cursos.modulos.curso.DAO.AppDAO;
import com.cursos.modulos.curso.Pessoa.Pessoa;
import com.cursos.modulos.curso.Roles.Roles;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CursosApplication {

	public static void main(String[] args) {
		SpringApplication.run(CursosApplication.class, args);
	}


	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO){

		return runner ->{
			//cadastrarPessoa(appDAO);
			//findPessoa(appDAO);
			//deletePessoa(appDAO);
		};
	}

	private void deletePessoa(AppDAO appDAO) {
		int oId = 2;

		appDAO.deletePessoaById(oId);

		System.out.println("Feito!");
	}

	private void findPessoa(AppDAO appDAO) {

		int oId = 2;
		System.out.println("Procurando pessoa id: " + oId);

		Pessoa tempPessoa = appDAO.findPessoaById(oId);

		System.out.println("Pessoa: " + tempPessoa);
		System.out.println("ROLE: " + tempPessoa.getRoles());

	}

	/*
	private void cadastrarPessoa(AppDAO appDAO) {

		Pessoa tempPessoa =
				new Pessoa("Carlos", "23047588810", "Carlos Pilotto", "21899672511", "carlos@gmail.com",
				"M", "1976-08-12","37842015","Brasil", "Santa Tereza", "São Paulo", "SP","73",
				"{bcrypt}$2a$10$6CIrQ1mOGj3wxyDhB6zbhuJaR3jztI2nQ.ItZWmIvW5eDvUvQiXs6", 1);

		Roles tempRoles =
				new Roles();

		// Set the existing Roles entity on the Pessoa entity
		tempPessoa.setRoles(tempRoles);

		// Save the Pessoa entity
		System.out.println("Salvando pessoa: " + tempPessoa);
		appDAO.save(tempPessoa);

		System.out.println("Feito!");
	}

}
*/


//@RestController
//class HttpController{
	//@GetMapping("/pessoas/create")
	//String publicRoute(){
		//return "<h1>REGISTRO DE PESSOA</h1>";
	//}
//}
}