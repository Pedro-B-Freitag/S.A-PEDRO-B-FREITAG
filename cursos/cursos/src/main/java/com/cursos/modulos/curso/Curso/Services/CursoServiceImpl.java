package com.cursos.modulos.curso.Curso.Services;

import com.cursos.modulos.curso.Curso.Curso;
import com.cursos.modulos.curso.Curso.DAOs.CursoDAO;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoServiceImpl implements CursoService{

    private CursoDAO cursoDAO;

    @Autowired
    public CursoServiceImpl(CursoDAO oCursoDAO){
        cursoDAO = oCursoDAO;
    }

    @Override
    public List<Curso> findAll() {
        return cursoDAO.findAll();
    }

    @Override
    public Curso findById(int oId) {
        return cursoDAO.findById(oId);
    }

    @Transactional
    @Override
    public Curso save(Curso oCurso) {
        return cursoDAO.save(oCurso);
    }

    @Transactional
    @Override
    public void deleteById(int oId) {
        cursoDAO.deleteById(oId);
    }
}
