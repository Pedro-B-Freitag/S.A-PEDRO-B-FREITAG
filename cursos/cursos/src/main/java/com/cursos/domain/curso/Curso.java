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
@EqualsAndHashCode(of = "curso_id")

public class Curso {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private     Integer     curso_id;
    private     String    curso_descricao;
    private     String    curso_categoria;
    private     String    curso_fornecedor;
    private     String    curso_nome;
    private     String    curso_url;
    private     Character curso_presencial;
    private     Blob      curso_img;
    private     Integer   curso_visualizacao;
    private     Integer   curso_gostei;
    private     Time      curso_qtd_hrs;

    public Curso(RequestCurso requestCurso){
        this.curso_descricao = requestCurso.curso_descricao();
        this.curso_categoria = requestCurso.curso_categoria();
        this.curso_fornecedor = requestCurso.curso_fornecedor();
        this.curso_nome = requestCurso.curso_nome();
        this.curso_url = requestCurso.curso_url();
        this.curso_presencial = requestCurso.curso_presencial();
        this.curso_img = requestCurso.curso_img();
        this.curso_visualizacao = requestCurso.curso_visualizacao();
        this.curso_gostei = requestCurso.curso_gostei();
        this.curso_qtd_hrs = requestCurso.curso_qtd_hrs();
    }





}
