package com.cursos.modulos.curso.Curso.DAOs;

import com.cursos.modulos.curso.Curso.Curso;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CursoDAO {

    List<Curso> findAll();
    Curso findById(int oId);
    Curso save(Curso oCurso);
    void deleteById(int oId);

}
