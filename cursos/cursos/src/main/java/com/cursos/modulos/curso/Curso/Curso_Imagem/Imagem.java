package com.cursos.modulos.curso.Curso.Curso_Imagem;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Blob;

@Entity
@Table(name = "imagem_curso")
public class Imagem {
    @Id
    @Getter
    @Setter
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
    public Blob getImage() {
        return imagem;
    }
    public void setImage(Blob imagem) {
        this.imagem = imagem;
    }
}