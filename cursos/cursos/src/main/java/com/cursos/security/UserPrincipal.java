package com.cursos.security;

import com.cursos.modulos.curso.Pessoa.entidades.Pessoa;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class UserPrincipal implements UserDetails {

    private     String  cpf;
    private     String  nome;
    private     String  contato;
    private     String  email;
    private     String  genero;
    private     Date    dataNascimento;
    private     String  cep;
    private     String  rua;
    private     String  bairro;
    private     String  cidade;
    private     String  estado;
    private     Integer nrResidencia;
    private     String  usuario;
    private     String  senha;
    private     Collection<? extends GrantedAuthority> authorities;


    public UserPrincipal(Pessoa pessoa){

        this.cpf = pessoa.getCpf();
        this.nome = pessoa.getNome();
        this.contato = pessoa.getContato();
        this.email = pessoa.getEmail();
        this.genero = pessoa.getGenero();
        this.dataNascimento = pessoa.getDataNascimento();
        this.cep = pessoa.getCep();
        this.rua = pessoa.getRua();
        this.bairro = pessoa.getBairro();
        this.cidade = pessoa.getCidade();
        this.estado = pessoa.getEstado();
        this.nrResidencia = pessoa.getNrResidencia();
        this.usuario = pessoa.getUsuario();
        this.senha = pessoa.getSenha();

        List<SimpleGrantedAuthority> authorities = new ArrayList<>();

        authorities = pessoa.getRoles().stream().map(role -> {
            return new SimpleGrantedAuthority("ROLE_".concat(role.getNome()));
        }).collect(Collectors.toList());

        this.authorities = authorities;
    }

    public static UserPrincipal create(Pessoa pessoa){
        return new UserPrincipal(pessoa);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return usuario;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
