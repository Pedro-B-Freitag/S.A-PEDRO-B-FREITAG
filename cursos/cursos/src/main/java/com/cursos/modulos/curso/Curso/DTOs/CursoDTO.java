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
    private Curso curso;
    private Blob imagem;

    public Imagem getImagem() {
        Imagem imagemObj = new Imagem();
        imagemObj.setImagem(imagem);
        return imagemObj;
    }

    public void setImagem(Blob imagem) {
        this.imagem = imagem;
    }
}
