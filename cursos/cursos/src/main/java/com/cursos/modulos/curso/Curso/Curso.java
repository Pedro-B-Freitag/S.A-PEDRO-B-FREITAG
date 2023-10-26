package com.cursos.modulos.curso.Curso;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Blob;

@Entity
@Table(name = "curso")
@Getter
@Setter
@ToString
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "categoria")
    private String categoria;
    @Column(name = "fornecedor")
    private String fornecedor;
    @Column(name = "nome")
    private String nome;
    @Column(name = "url")
    private String url;
    @Column(name = "presencial")
    private Boolean presencial;
    @Column(name = "visualizacao")
    private Integer visualizacao;
    @Column(name = "gostei")
    private Integer gostei;
    @Column(name = "qtd_hrs")
    private String qtdHoras;
    @Lob
    private Blob imagem;


    public Curso(){

    }

    public Curso(String descricao, String categoria, String fornecedor, String nome,
                 String url, Boolean presencial, Integer visualizacao, Integer gostei,
                 String qtdHoras, Blob imagem) {

        this.descricao = descricao;
        this.categoria = categoria;
        this.fornecedor = fornecedor;
        this.nome = nome;
        this.url = url;
        this.presencial = presencial;
        this.visualizacao = visualizacao;
        this.gostei = gostei;
        this.qtdHoras = qtdHoras;
        this.imagem = imagem;

    }

    public Blob getImagem() {
        return imagem;
    }
    public void setImagem(Blob imagem) {
        this.imagem = imagem;
    }

}
