package com.cursos.modulos.curso.Vaga.DAOs;

import com.cursos.modulos.curso.Vaga.Vaga;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class VagaDAOJpaImpl implements VagaDAO {

    private EntityManager entityManager;

    @Autowired
    public VagaDAOJpaImpl(EntityManager oentityManager){
        entityManager = oentityManager;
    }


    @Override
    public List<Vaga> findAll() {
        TypedQuery<Vaga> theQuery = entityManager.createQuery("from Vaga", Vaga.class);

        List<Vaga> vaga = theQuery.getResultList();


        return vaga;
    }


    @Override
    public Vaga findById(int oId) {

        Vaga aVaga = entityManager.find(Vaga.class, oId);

        return aVaga;

    }



    @Override
    public Vaga save(Vaga aVaga) {

        Vaga bdVaga = entityManager.merge(aVaga);

        return bdVaga;

    }



    @Override
    public void deleteById(int oId) {

        Vaga aVaga = entityManager.find(Vaga.class, oId);

        entityManager.remove(aVaga);

    }
}
