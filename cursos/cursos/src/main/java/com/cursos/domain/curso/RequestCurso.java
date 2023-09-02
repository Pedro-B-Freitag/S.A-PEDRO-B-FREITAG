package com.cursos.domain.curso;

import java.sql.Blob;
import java.sql.Time;


//DTOS
public record RequestCurso (Integer curso_id,String curso_descricao, String    curso_categoria, String    curso_fornecedor, String    curso_nome,
             String    curso_url, Character curso_presencial, Blob curso_img, Integer   curso_visualizacao,
             Integer   curso_gostei, Time curso_qtd_hrs){
}
