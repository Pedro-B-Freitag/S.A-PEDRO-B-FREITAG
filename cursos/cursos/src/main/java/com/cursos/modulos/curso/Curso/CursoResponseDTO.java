package com.cursos.modulos.curso.Curso;

import java.sql.Time;

public record CursoResponseDTO(Integer id, String descricao, String categoria, String fornecedor, String nome, String url,
                               Boolean presencial, Integer visualizacao, Integer gostei, String qtdHrs, String imagem) {


        public CursoResponseDTO(Curso curso){
            this(curso.getId(),curso.getDescricao(),curso.getCategoria(),curso.getFornecedor(),curso.getNome(),
            curso.getUrl(),curso.getPresencial(),curso.getVisualizacao(),curso.getGostei(),curso.getQtdHrs(), curso.getImagem());
        }


}
