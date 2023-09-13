package com.cursos.security;

import com.cursos.modulos.curso.Pessoa.PessoaRepositorio;
import com.cursos.modulos.curso.Pessoa.entidades.Pessoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class CustomPessoaDetailsService implements UserDetailsService {




    @Autowired
    PessoaRepositorio pessoaRepositorio;


    @Override
    public UserDetails loadUserByUsername(String cpf) throws UsernameNotFoundException {

        Pessoa pessoaExiste = pessoaRepositorio.findByCpfFetchRoles(cpf);

        if (pessoaExiste != null) {
            throw new Error("Usuario ja existe!!");
        }

        return UserPrincipal.create(pessoaExiste);
    }
}
