package com.cursos.modulos.curso.Pessoa.entidades;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.sql.Date;
import java.util.Collection;
import java.util.List;
/*
@Table(name = "pessoa")
@Entity (name = "pessoa")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

public class Pessoa implements UserDetails {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private     Integer id;
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


    @ManyToMany
    private List<Role> roles;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
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
*/