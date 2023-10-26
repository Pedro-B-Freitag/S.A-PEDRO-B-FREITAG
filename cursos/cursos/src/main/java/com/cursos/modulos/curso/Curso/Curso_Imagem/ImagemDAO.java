package com.cursos.modulos.curso.Curso.Curso_Imagem;

import com.cursos.modulos.curso.Curso.Curso;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImagemDAO extends CrudRepository<Curso, Integer> {

}
