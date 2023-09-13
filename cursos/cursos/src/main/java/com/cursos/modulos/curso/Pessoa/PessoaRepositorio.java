package com.cursos.modulos.curso.Pessoa;

import com.cursos.modulos.curso.Pessoa.entidades.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PessoaRepositorio extends JpaRepository<Pessoa, Integer> {
    Pessoa findByCpf(String cpf);
    @Query("SELECT p from pessoa p JOIN FETCH p.roles where p.cpf = :cpf ")
    Pessoa findByCpfFetchRoles(@Param("cpf") String cpf);

}