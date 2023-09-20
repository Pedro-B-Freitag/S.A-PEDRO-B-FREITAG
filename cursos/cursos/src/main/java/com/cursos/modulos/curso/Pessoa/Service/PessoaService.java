package com.cursos.modulos.curso.Pessoa.Service;

import com.cursos.modulos.curso.Pessoa.Pessoa;

import java.util.List;

public interface PessoaService {

    List<Pessoa> findAll();
    Pessoa findById(int oId);
    Pessoa save(Pessoa aPessoa);
    void deleteById(int oId);

}
