package com.cursos.modulos.curso.Pessoa.DAOs;

import com.cursos.modulos.curso.Pessoa.Pessoa;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


import java.util.List;

public interface PessoaDAO {
    List<Pessoa> findAll();
    Pessoa findById(int oId);
    Pessoa save(Pessoa aPessoa);
    void deleteById(int oId);

}


