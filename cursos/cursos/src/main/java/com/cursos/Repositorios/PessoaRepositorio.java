package com.cursos.Repositorios;

import com.cursos.domain.curso.Pessoa.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface PessoaRepositorio extends JpaRepository<Pessoa, Integer> {
    UserDetails findByPessoaCpf(String pessoaCpf);
}