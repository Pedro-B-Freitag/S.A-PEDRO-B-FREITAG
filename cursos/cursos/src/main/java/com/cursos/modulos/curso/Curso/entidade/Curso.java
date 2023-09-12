package com.cursos.modulos.curso.Curso.entidade;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Time;

@Table(name = "curso")
@Entity(name = "curso")
@Data

public class Curso {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private     Integer   id;
    private     String    descricao;
    private     String    categoria;
    private     String    fornecedor;
    private     String    nome;
    private     String    url;
    private     Boolean   presencial;
    private     Integer   visualizacao;
    private     Integer   gostei;
    private     Time      qtdHrs;

}
