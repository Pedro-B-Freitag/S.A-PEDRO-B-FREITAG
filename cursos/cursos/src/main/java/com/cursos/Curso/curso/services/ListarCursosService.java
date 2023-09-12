package com.cursos.Curso.curso.services;

import com.cursos.Curso.curso.CursoRepositorio;
import com.cursos.Curso.curso.entidades.Curso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListarCursosService {

    @Autowired
    CursoRepositorio cursoRepositorio;

    public List<Curso> listAll(){
        return cursoRepositorio.findAll();
    }
}
