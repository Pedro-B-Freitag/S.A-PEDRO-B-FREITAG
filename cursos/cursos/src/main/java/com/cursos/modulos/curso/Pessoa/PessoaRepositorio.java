package com.cursos.modulos.curso.Pessoa;

import com.cursos.modulos.curso.Pessoa.entidades.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetails;

public interface PessoaRepositorio extends JpaRepository<Pessoa, Integer> {
    @Query("SELECT p from pessoa p JOIN FETCH p.roles where p.usuario = :usuario  ")
    Pessoa findByUsuarioFetchRoles(@Param("usuario") String usuario);

    Pessoa findByUsuario(String usuario);

}