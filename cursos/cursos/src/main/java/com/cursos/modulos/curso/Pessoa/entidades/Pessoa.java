package com.cursos.modulos.curso.Pessoa.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.util.List;

@Table(name = "pessoa")
@Entity (name = "pessoa")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

public class Pessoa {

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

}
