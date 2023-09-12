package com.cursos.modulos.curso.Curso.services;

import com.cursos.modulos.curso.Curso.CursoRepositorio;
import com.cursos.modulos.curso.Curso.entidade.Curso;
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
