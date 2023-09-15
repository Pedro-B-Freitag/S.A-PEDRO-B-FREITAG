package com.cursos.modulos.curso.Pessoa.services;

import com.cursos.modulos.curso.Pessoa.PessoaRepositorio;
import com.cursos.modulos.curso.Pessoa.entidades.Pessoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service

public class CreatePessoaService {

    @Autowired
    PessoaRepositorio pessoaRepositorio;



    private BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    public Pessoa execute(Pessoa pessoa) {

        Pessoa pessoaExiste = pessoaRepositorio.findByUsuario(pessoa.getUsuario());

        if (pessoaExiste != null) {
            throw new Error("Usuario ja existe!!");
        }

        pessoa.setSenha(passwordEncoder().encode(pessoa.getSenha()));

        Pessoa pessoaCriada = pessoaRepositorio.save(pessoa);

        return pessoaCriada;
    }
}
