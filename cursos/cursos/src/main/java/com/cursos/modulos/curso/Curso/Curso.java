package com.cursos.modulos.curso.Curso;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Time;

@Table(name = "curso")
@Entity(name = "curso")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")

public class Curso {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)

    private     Integer   id;

    private     String    descricao;

    private     String    categoria;

    private     String    fornecedor;

    private     String    nome;

    private     String    url;

    private     Boolean   presencial;

    private     Integer   visualizacao;

    private     Integer   gostei;

    private     String      qtdHrs;

    private     String    imagem;



    public Curso(CursoRequestDTO data){
        this.descricao = data.descricao();
        this.categoria = data.categoria();
        this.fornecedor = data.fornecedor();
        this.nome = data.nome();
        this.url = data.url();
        this.presencial = data.presencial();
        this.visualizacao = data.visualizacao();
        this.gostei = data.gostei();
        this.qtdHrs = data.qtdHrs();
        this.imagem = data.imagem();
    }

}
