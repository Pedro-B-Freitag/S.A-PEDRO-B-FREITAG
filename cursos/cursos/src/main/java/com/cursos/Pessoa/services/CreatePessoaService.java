package com.cursos.Pessoa.services;

import com.cursos.Pessoa.PessoaRepositorio;
import com.cursos.Pessoa.entidade.Pessoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class CreatePessoaService {

    @Autowired
    PessoaRepositorio pessoaRepositorio;

    public Pessoa execute(Pessoa pessoa) {
        Pessoa pessoaExiste = pessoaRepositorio.findById(pessoa.getId());

        if (pessoaExiste != null) {
            throw new Error("Usuario ja existe!!");
        }
        Pessoa pessoaCriada = pessoaRepositorio.save(pessoa);
        return pessoaCriada;
    }
}
