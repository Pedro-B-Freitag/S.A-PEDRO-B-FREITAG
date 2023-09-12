package com.cursos.modulos.curso.Pessoa;

import com.cursos.modulos.curso.Pessoa.entidades.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepositorio extends JpaRepository<Pessoa, Integer> {
    Pessoa findByCpf(String cpf);
}