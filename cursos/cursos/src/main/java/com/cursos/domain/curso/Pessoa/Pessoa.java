package com.cursos.domain.curso.Pessoa;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.sql.Date;
import java.util.Collection;
import java.util.List;

@Table(name = "Pessoa")
@Entity (name = "Pessoa")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "pessoaId")
public class Pessoa implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private     Integer pessoaId;
    private     String  pessoaCpf;
    private     String  pessoaNome;
    private     String pessoaContato;
    private     String  pessoaEmail;
    private     String  pessoaGenero;
    private     Date    pessoaDataNascimento;
    private     String  pessoaCep;
    private     String  pessoaRua;
    private     String  pessoaBairro;
    private     String  pessoaCidade;
    private     String  pessoaEstado;
    private     Integer pessoaNrResidencia;
    private     String  pessoaUsuario;
    private     String  pessoaSenha;
    private     PessoaRole  pessoaRole;


    public Pessoa(String  pessoa_cpf, String  pessoa_nome, String pessoa_contato, String  pessoa_email,
                  String  pessoa_genero, Date    pessoa_data_nascimento, String  pessoa_cep, String  pessoa_rua,
                  String  pessoa_bairro, String  pessoa_cidade, String  pessoa_estado, Integer pessoa_nr_residencia,
                  String  pessoa_usuario, String  pessoa_senha, PessoaRole  pessoa_role){
        this.pessoaCpf = pessoa_cpf;
        this.pessoaNome = pessoa_nome;
        this.pessoaContato = pessoa_contato;
        this.pessoaEmail = pessoa_email;
        this.pessoaGenero = pessoa_genero;
        this.pessoaDataNascimento = pessoa_data_nascimento;
        this.pessoaCep = pessoa_cep;
        this.pessoaRua = pessoa_rua;
        this.pessoaBairro = pessoa_bairro;
        this.pessoaCidade = pessoa_cidade;
        this.pessoaEstado = pessoa_estado;
        this.pessoaNrResidencia = pessoa_nr_residencia;
        this.pessoaUsuario = pessoa_usuario;
        this.pessoaSenha= pessoa_senha;
        this.pessoaRole = pessoa_role;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //quando um usuario for admin ele tera as permissoes do sdmin e de uma pessoa normal
        if(this.pessoaRole == PessoaRole.ADMIN ) return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_USER"));
        else return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return pessoaSenha;
    }

    @Override
    public String getUsername() {
        return pessoaUsuario;
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
