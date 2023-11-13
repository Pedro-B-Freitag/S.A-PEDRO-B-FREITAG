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
    @Column(name = "pessoa_id")
    private Integer id;
    @Column(name = "pessoa_cpf")
    private String cpf;
    @Column(name = "pessoa_nome")
    private String nome;
    @Column(name = "pessoa_contato")
    private String contato;
    @Column(name = "pessoa_email")
    private String email;
    @Column(name = "pessoa_genero")
    private String genero;
    @Column(name = "pessoa_data_nascimento")
    private Date dataNascimento;
    @Column(name = "pessoa_cep")
    private String cep;
    @Column(name = "pessoa_rua")
    private String rua;
    @Column(name = "pessoa_bairro")
    private String bairro;
    @Column(name = "pessoa_cidade")
    private String cidade;
    @Column(name = "pessoa_estado")
    private String estado;
    @Column(name = "pessoa_nr_residencia")
    private Integer nrResidencia;
    @Column(name = "pessoa_senha")
    private String senha;
    @Column(name = "pessoa_ativado")
    private Integer ativado;

    @OneToOne
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
