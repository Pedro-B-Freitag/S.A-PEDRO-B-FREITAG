package com.cursos.modulos.curso.Pessoa.entidades;

import com.cursos.modulos.curso.Roles.Entidade.Roles;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.sql.Date;
import java.util.Collection;
import java.util.List;

@Table(name = "pessoa")
@Entity
@Getter
@Setter


public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String usuario;
    @Column(name = "id")
    private Integer id;
    @Column(name = "cpf")
    private String cpf;
    @Column(name = "nome")
    private String nome;
    @Column(name = "contato")
    private String contato;
    @Column(name = "email")
    private String email;
    @Column(name = "genero")
    private String genero;
    @Column(name = "data_nascimento")
    private Date dataNascimento;
    @Column(name = "cep")
    private String cep;
    @Column(name = "rua")
    private String rua;
    @Column(name = "bairro")
    private String bairro;
    @Column(name = "cidade")
    private String cidade;
    @Column(name = "estado")
    private String estado;
    @Column(name = "nr_residencia")
    private Integer nrResidencia;
    @Column(name = "senha")
    private String senha;

    @OneToMany(mappedBy = "usuario")
    private List<Roles> roles;
    public Pessoa(){}

    public Pessoa(String usuario,  String cpf, String nome, String contato, String email, String genero, Date dataNascimento, String cep, String rua,
                  String bairro, String cidade, String estado, Integer nrResidencia, String senha) {

        this.usuario = usuario;
        this.cpf     = cpf;
        this.nome    = nome;
        this.contato = contato;
        this.email = email;
        this.genero = genero;
        this.dataNascimento = dataNascimento;
        this.cep = cep;
        this.rua = rua;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.nrResidencia = nrResidencia;
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Pessoa{"            +
                "usuario='"         + usuario        + '\'' +
                ", id="             + id             +
                ", cpf='"           + cpf            + '\'' +
                ", nome='"          + nome           + '\'' +
                ", contato='"       + contato        + '\'' +
                ", email='"         + email          + '\'' +
                ", genero='"        + genero         + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", cep='"           + cep            + '\'' +
                ", rua='"           + rua            + '\'' +
                ", bairro='"        + bairro         + '\'' +
                ", cidade='"        + cidade         + '\'' +
                ", estado='"        + estado         + '\'' +
                ", nrResidencia="   + nrResidencia   +
                ", senha='"         + senha          + '\'' +
                '}';
    }
}
