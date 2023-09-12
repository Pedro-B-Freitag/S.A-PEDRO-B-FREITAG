package com.cursos.modulos.curso.Curso;

import com.cursos.modulos.curso.Curso.entidade.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

//Repositorio usado para criar consultas no database
public interface CursoRepositorio extends JpaRepository<Curso, Integer> {

}
    //JPARepository cria todos os metodos em Runtime recebendo a entidade manipulada e o tipo da primary key
    //metodos padroes: getReference by id, getAll by id, DeleteAll, etc.

