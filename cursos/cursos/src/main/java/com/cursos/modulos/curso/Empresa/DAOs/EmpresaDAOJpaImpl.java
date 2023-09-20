package com.cursos.modulos.curso.Empresa.DAOs;

import com.cursos.modulos.curso.Curso.Curso;
import com.cursos.modulos.curso.Empresa.Empresa;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
@Repository
public class EmpresaDAOJpaImpl implements EmpresaDAO{

    private EntityManager entityManager;

    @Autowired
    public EmpresaDAOJpaImpl(EntityManager oentityManager){
        entityManager = oentityManager;
    }


    @Override
    public List<Empresa> findAll() {
        TypedQuery<Empresa> theQuery = entityManager.createQuery("from Empresa", Empresa.class);

        List<Empresa> empresa = theQuery.getResultList();


        return empresa;
    }




    @Override
    public Empresa findById(int oId) {
        Empresa aEmpresa = entityManager.find(Empresa.class, oId);

        return aEmpresa;
    }

    @Override
    public Empresa save(Empresa aEmpresa) {
        Empresa bdEmpresa = entityManager.merge(aEmpresa);

        return bdEmpresa;
    }

    @Override
    public void deleteById(int oId) {

        Empresa aEmpresa = entityManager.find(Empresa.class, oId);

        entityManager.remove(aEmpresa);

    }
}
