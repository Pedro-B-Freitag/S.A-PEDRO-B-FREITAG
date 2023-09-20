package com.cursos.modulos.curso.Curso.DAOs;

import com.cursos.modulos.curso.Curso.Curso;
import com.cursos.modulos.curso.Curso.DAOs.CursoDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CursoDAOJpaImpl implements CursoDAO {

    private EntityManager entityManager;

    @Autowired
    public CursoDAOJpaImpl(EntityManager oentityManager){
        entityManager = oentityManager;
    }


    @Override
    public List<Curso> findAll() {
        TypedQuery<Curso> theQuery = entityManager.createQuery("from Curso", Curso.class);

        List<Curso> curso = theQuery.getResultList();


        return curso;
    }

    @Override
    public Curso findById(int oId) {

        Curso oCurso = entityManager.find(Curso.class, oId);

        return oCurso;

    }



    @Override
    public Curso save(Curso oCurso) {

        Curso bdCurso = entityManager.merge(oCurso);

        return bdCurso;

    }



    @Override
    public void deleteById(int oId) {

        Curso oCurso = entityManager.find(Curso.class, oId);

        entityManager.remove(oCurso);

    }
}
