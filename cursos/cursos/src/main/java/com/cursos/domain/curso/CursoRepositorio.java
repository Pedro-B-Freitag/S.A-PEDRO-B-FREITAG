package com.cursos.domain.curso;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//Repositorio usado para criar consultas no database
public interface CursoRepositorio extends JpaRepository<Curso, Integer> {

    List<Curso> findAllByCursoPresencialTrue();


}
    //JPARepository cria todos os metodos em Runtime recebendo a entidade manipulada e o tipo da primary key
    //metodos padroes: getReference by id, getAll by id, DeleteAll, etc.

