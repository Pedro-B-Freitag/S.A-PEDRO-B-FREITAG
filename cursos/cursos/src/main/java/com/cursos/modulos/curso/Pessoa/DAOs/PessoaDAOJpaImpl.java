package com.cursos.modulos.curso.Pessoa.DAOs;

import com.cursos.modulos.curso.Empresa.Empresa;
import com.cursos.modulos.curso.Pessoa.Pessoa;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PessoaDAOJpaImpl implements PessoaDAO{

    private EntityManager entityManager;

    @Autowired
    public PessoaDAOJpaImpl(EntityManager oentityManager){
        entityManager = oentityManager;
    }




    @Override
    public List<Pessoa> findAll() {
        TypedQuery<Pessoa> theQuery = entityManager.createQuery("from Pessoa", Pessoa.class);

        List<Pessoa> pessoa = theQuery.getResultList();


        return pessoa;
    }




    @Override
    public Pessoa findById(int oId) {
        Pessoa aPessoa = entityManager.find(Pessoa.class, oId);

        return aPessoa;
    }

    @Override
    public Pessoa save(Pessoa aPessoa) {
        Pessoa bdPessoa = entityManager.merge(aPessoa);

        return bdPessoa;
    }

    @Override
    public void deleteById(int oId) {

        Pessoa aPessoa = entityManager.find(Pessoa.class, oId);

        entityManager.remove(aPessoa);

    }
}
