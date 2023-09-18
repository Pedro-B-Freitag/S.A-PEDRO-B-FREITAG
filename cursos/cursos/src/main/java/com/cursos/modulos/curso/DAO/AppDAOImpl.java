package com.cursos.modulos.curso.DAO;

import com.cursos.modulos.curso.Pessoa.Pessoa;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AppDAOImpl implements AppDAO{

    private EntityManager entityManager;

    @Autowired
    public AppDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }
    @Override
    @Transactional
    public void save(Pessoa aPessoa) {
        entityManager.persist(aPessoa);
    }
}
