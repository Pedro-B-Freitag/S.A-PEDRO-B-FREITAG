package com.cursos.modulos.curso.Pessoa.Service;

import com.cursos.modulos.curso.Empresa.DAOs.EmpresaDAO;
import com.cursos.modulos.curso.Pessoa.DAOs.PessoaDAO;
import com.cursos.modulos.curso.Pessoa.Pessoa;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaServiceImpl implements PessoaService {


    private PessoaDAO pessoaDAO;


    @Autowired
    public PessoaServiceImpl(PessoaDAO aPessoaDAO){
        pessoaDAO = aPessoaDAO;
    }


    @Override
    public List<Pessoa> findAll() {
        return pessoaDAO.findAll();
    }

    @Override
    public Pessoa findById(int oId) {
        return pessoaDAO.findById(oId);
    }

    @Transactional
    @Override
    public Pessoa save(Pessoa aPessoa) {
        return pessoaDAO.save(aPessoa);
    }

    @Transactional
    @Override
    public void deleteById(int oId) {
        pessoaDAO.deleteById(oId);
    }
}
