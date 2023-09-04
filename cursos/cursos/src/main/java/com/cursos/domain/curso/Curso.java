package com.cursos.domain.curso;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Blob;
import java.sql.Time;

@Table(name = "curso")
@Entity(name = "curso")
//Cria os metodos getter e setter automaticamente
@Getter
@Setter
//Cria um contrutor automaticamente
@AllArgsConstructor
//Contrutor que n ao recebe parametro e nao retorna nada
@NoArgsConstructor
//Primary key
@EqualsAndHashCode(of = "cursoId")

public class Curso {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private     Integer   cursoId;
    private     String    cursoDescricao;
    private     String    cursoCategoria;
    private     String    cursoFornecedor;
    private     String    cursoNome;
    private     String    cursoUrl;
    private     Boolean  cursoPresencial;
    private     Blob      cursoImg;
    private     Integer   cursoVisualizacao;
    private     Integer   cursoGostei;
    private     Time      cursoQtdHrs;

    public Curso(RequestCurso requestCurso){
        this.cursoDescricao = requestCurso.curso_descricao();
        this.cursoCategoria = requestCurso.curso_categoria();
        this.cursoFornecedor = requestCurso.curso_fornecedor();
        this.cursoNome = requestCurso.curso_nome();
        this.cursoUrl = requestCurso.curso_url();
        this.cursoPresencial = requestCurso.curso_presencial();
        this.cursoImg = requestCurso.curso_img();
        this.cursoVisualizacao = requestCurso.curso_visualizacao();
        this.cursoGostei = requestCurso.curso_gostei();
        this.cursoQtdHrs = requestCurso.curso_qtd_hrs();
    }





}
