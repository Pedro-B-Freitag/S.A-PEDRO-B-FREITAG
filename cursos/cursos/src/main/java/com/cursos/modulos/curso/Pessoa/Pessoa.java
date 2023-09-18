package com.cursos.modulos.curso.Pessoa;

import com.cursos.modulos.curso.Roles.Roles;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;

@Table(name = "pessoa")
@Entity
@Getter
@Setter


public class Pessoa {


    @Column(name = "usuario")
    private String usuario;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @Column(name = "ativado")
    private Integer ativado;

    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "roles_id")
    private Roles roles;

    public Pessoa(){}

    public Pessoa(String usuario, String cpf, String nome, String contato, String email, String genero, String dataNascimento, String cep, String rua,
                  String bairro, String cidade, String estado, String nrResidencia, String senha, Integer ativado) {

        this.usuario = usuario;
        this.cpf     = cpf;
        this.nome    = nome;
        this.contato = contato;
        this.email = email;
        this.genero = genero;
        this.dataNascimento = Date.valueOf(dataNascimento);
        this.cep = cep;
        this.rua = rua;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.nrResidencia = Integer.valueOf(nrResidencia);
        this.senha = senha;
        this.ativado = ativado;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "usuario='" + usuario + '\'' +
                ", id=" + id +
                ", cpf='" + cpf + '\'' +
                ", nome='" + nome + '\'' +
                ", contato='" + contato + '\'' +
                ", email='" + email + '\'' +
                ", genero='" + genero + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", cep='" + cep + '\'' +
                ", rua='" + rua + '\'' +
                ", bairro='" + bairro + '\'' +
                ", cidade='" + cidade + '\'' +
                ", estado='" + estado + '\'' +
                ", nrResidencia=" + nrResidencia +
                ", senha='" + senha + '\'' +
                ", roles=" + roles +
                '}';
    }
}
