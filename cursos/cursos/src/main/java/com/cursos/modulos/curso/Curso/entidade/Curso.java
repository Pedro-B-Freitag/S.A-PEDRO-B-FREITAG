package com.cursos.modulos.curso.Curso.entidade;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Time;

@Table(name = "curso")
@Entity(name = "curso")
@Data
@Getter
@Setter

public class Curso {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private     Integer   id;
    @Column(name = "descricao")
    private     String    descricao;
    @Column(name = "categoria")
    private     String    categoria;
    @Column(name = "fornecedor")
    private     String    fornecedor;
    @Column(name = "nome")
    private     String    nome;
    @Column(name = "url")
    private     String    url;
    @Column(name = "presencial")
    private     Boolean   presencial;
    @Column(name = "visualizacao")
    private     Integer   visualizacao;
    @Column(name = "gostei")
    private     Integer   gostei;
    @Column(name = "qtd_hrs")
    private     Time      qtdHrs;

    public Curso(){

    }

    //construtores
    public Curso(String descricao, String categoria, String fornecedor, String nome, String url,
                 Boolean presencial, Integer visualizacao, Integer gostei, Time qtdHrs) {

        this.descricao = descricao;
        this.categoria = categoria;
        this.fornecedor = fornecedor;
        this.nome = nome;
        this.url = url;
        this.presencial = presencial;
        this.visualizacao = visualizacao;
        this.gostei = gostei;
        this.qtdHrs = qtdHrs;

    }


    @Override
    public String toString() {
        return "Curso{" +
                "id=" + id +
                ", descricao='"   + descricao    + '\'' +
                ", categoria='"   + categoria    + '\'' +
                ", fornecedor='"  + fornecedor   + '\'' +
                ", nome='"        + nome         + '\'' +
                ", url='"         + url          + '\'' +
                ", presencial="   + presencial   +
                ", visualizacao=" + visualizacao +
                ", gostei="       + gostei       +
                ", qtdHrs="       + qtdHrs       +
                '}';
    }
}
