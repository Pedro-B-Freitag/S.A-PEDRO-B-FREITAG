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
public class Pessoa {

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


    public Pessoa(String  pessoa_cpf, String  pessoa_nome, String pessoa_contato, String  pessoa_email,
                  String  pessoa_genero, Date    pessoa_data_nascimento, String  pessoa_cep, String  pessoa_rua,
                  String  pessoa_bairro, String  pessoa_cidade, String  pessoa_estado, Integer pessoa_nr_residencia,
                  String  pessoa_usuario, String  pessoa_senha){
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
    }

}
