package com.cursos.modulos.curso.Pessoa;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepositorio extends JpaRepository<Pessoa, Integer> {

    Pessoa findByUsuario(String usuario);

}


