package com.cursos.modulos.curso.Curso.Imagem;

import jakarta.persistence.*;
import java.sql.Blob;
import java.util.Date;

@Entity
@Table(name = "imagem")
public class Imagem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Lob
    private Blob imagem;


    public long getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Blob getImagem() {
        return imagem;
    }

    public void setImagem(Blob imagem) {
        this.imagem = imagem;
    }

}
