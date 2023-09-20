package com.cursos.modulos.curso.Pessoa.DAOs;

import com.cursos.modulos.curso.Empresa.Empresa;
import com.cursos.modulos.curso.Pessoa.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PessoaDAO {

    List<Pessoa> findAll();
    Pessoa findById(int oId);
    Pessoa save(Pessoa aPessoa);
    void deleteById(int oId);

}


