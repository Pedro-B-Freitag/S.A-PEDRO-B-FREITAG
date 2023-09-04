package com.cursos.Services;


import com.cursos.Repositorios.PessoaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthorizationService implements UserDetailsService {

    @Autowired
    PessoaRepositorio repository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //sera capaz de consultar os usuarios no bd na tabela criada
        return repository.findByPessoaCpf(username);
    }
}
