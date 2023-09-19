package com.cursos.modulos.curso.Curso;

import java.sql.Time;

public record CursoRequestDTO(String descricao, String categoria, String fornecedor, String nome, String url,
                              Boolean presencial, Integer visualizacao, Integer gostei, String qtdHrs, String imagem) {
}
