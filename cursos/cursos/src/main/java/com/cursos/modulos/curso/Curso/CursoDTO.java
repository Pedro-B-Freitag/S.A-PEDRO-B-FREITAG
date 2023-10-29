package com.cursos.modulos.curso.Curso;

import com.cursos.modulos.curso.Curso.Imagem.Imagem;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
public class CursoDTO {

    @Getter
    @Setter
    private Curso curso;
    private Imagem imagem;

    public Imagem getImagem() {
        return imagem;
    }

    public void setImagem(Imagem imagem) {
        this.imagem = imagem;
    }
}
