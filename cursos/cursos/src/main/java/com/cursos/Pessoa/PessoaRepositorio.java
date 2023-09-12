package com.cursos.Pessoa;

import com.cursos.Pessoa.entidade.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.UUID;

public interface PessoaRepositorio extends JpaRepository<Pessoa, Integer> {
    Pessoa findById(UUID pessoaId);
}