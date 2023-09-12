package com.cursos.modulos.curso.Pessoa.services;

import com.cursos.modulos.curso.Pessoa.PessoaRepositorio;
import com.cursos.modulos.curso.Pessoa.entidades.Pessoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service

public class CreatePessoaService {

    @Autowired
    PessoaRepositorio pessoaRepositorio;

    public Pessoa execute(Pessoa pessoa) {
        Pessoa pessoaExiste = pessoaRepositorio.findByCpf(pessoa.getCpf());

        if (pessoaExiste != null) {
            throw new Error("Usuario ja existe!!");
        }
        Pessoa pessoaCriada = pessoaRepositorio.save(pessoa);
        return pessoaCriada;
    }
}
