package com.cursos.domain.curso.Pessoa;

import java.sql.Date;

<<<<<<< HEAD
public record RegisterDTO(String  pessoa_cpf, String  pessoa_nome, Integer pessoa_contato, String  pessoa_email,
=======
public record RegisterDTO(String  pessoa_cpf, String  pessoa_nome, String pessoa_contato, String  pessoa_email,
>>>>>>> 3d62b60d48dc8f90ef22393621118ee24dfdc214
                          String  pessoa_genero, Date    pessoa_data_nascimento, String  pessoa_cep, String  pessoa_rua,
                          String  pessoa_bairro, String  pessoa_cidade, String  pessoa_estado, Integer pessoa_nr_residencia,
                          String  pessoa_usuario, String  pessoa_senha, PessoaRole  pessoa_role) {
}
