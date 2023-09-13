package com.cursos.modulos.curso.Pessoa.dto;

import lombok.Data;

import java.util.List;


@Data
public class CreatePessoaRoleDTO {

    private Integer idPessoa;

    private List<Integer> idRole;

}