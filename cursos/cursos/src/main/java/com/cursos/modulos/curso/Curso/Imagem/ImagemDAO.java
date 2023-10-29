package com.cursos.modulos.curso.Curso.Imagem;

import com.cursos.modulos.curso.Curso.Curso;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImagemDAO extends CrudRepository<Imagem, Integer> {

}
