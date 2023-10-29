package com.cursos.modulos.curso.Curso.Services;

import com.cursos.modulos.curso.Curso.Curso;
import jakarta.transaction.Transactional;

import java.util.List;

public interface CursoService {
    List<Curso> findAll();

    Curso findById(Integer oId);

    void save(Curso oCurso);

    void deleteById(Integer oId);
}
