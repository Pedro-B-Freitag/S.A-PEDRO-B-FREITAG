package com.cursos.security;
/*
import com.cursos.modulos.curso.Pessoa.PessoaRepositorio;
import com.cursos.modulos.curso.Pessoa.entidades.Pessoa;
import com.cursos.security.UserPrincipal;
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
    public UserDetails loadUserByUsername(String usuario) throws UsernameNotFoundException {
        Pessoa pessoa = pessoaRepositorio.findByUsuarioFetchRoles(usuario);

        if (pessoa == null) {
            throw new UsernameNotFoundException("Usuário não encontrado: " + usuario);
        }

        return UserPrincipal.create(pessoa);
    }
}

*/