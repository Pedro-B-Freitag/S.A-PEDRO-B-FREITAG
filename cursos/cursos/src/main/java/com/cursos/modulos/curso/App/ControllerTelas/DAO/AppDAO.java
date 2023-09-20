package com.cursos.modulos.curso.App.ControllerTelas.DAO;

import com.cursos.modulos.curso.Pessoa.Pessoa;

public interface AppDAO {
    void save(Pessoa aPessoa);
    Pessoa findPessoaById(int oId);

    void deletePessoaById(int oId);
}
