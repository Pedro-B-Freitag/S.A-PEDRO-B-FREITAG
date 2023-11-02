package com.cursos.modulos.curso.Curso.DTOs;

import com.cursos.modulos.curso.Curso.Curso;
import com.cursos.modulos.curso.Curso.Imagem.Imagem;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.sql.Blob;

@Component
public class CursoDTO {

    @Getter
    @Setter
    private Imagem imagem;

    public Imagem getImagem() {
        return imagem;
    }

    public void setImagem(Imagem imagem) {
        this.imagem = imagem;
    }
}
