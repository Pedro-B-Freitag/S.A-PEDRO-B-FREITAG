package com.cursos.modulos.curso.Curso.Services;

import com.cursos.modulos.curso.Curso.Curso;

import java.util.List;

public interface CursoService {
    List<Curso> findAll();

    Curso findById(int oId);

    Curso save(Curso oCurso);

    void deleteById(int oId);
}
