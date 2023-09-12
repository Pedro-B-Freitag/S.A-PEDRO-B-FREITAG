package com.cursos.Pessoa.entidade;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

@Table(name = "Pessoa")
@Entity (name = "Pessoa")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "pessoaId")
public class Pessoa {

    @Id
    @GeneratedValue
    private     UUID    id;
    private     String  cpf;
    private     String  nome;
    private     String  contato;
    private     String  email;
    private     String  genero;
    @Column(name = "dataNascimento")
    private     Date    dataNascimento;
    private     String  cep;
    private     String  rua;
    private     String  bairro;
    private     String  cidade;
    private     String  estado;
    @Column(name = "nrResidencia")
    private     Integer nrResidencia;
    private     String  usuario;
    private     String  senha;


    @ManyToMany
    private List<Role> roles;

}
