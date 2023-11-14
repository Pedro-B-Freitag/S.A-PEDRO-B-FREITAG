package com.cursos.modulos.curso.Usuario;

import com.cursos.modulos.curso.Pessoa.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {
}
