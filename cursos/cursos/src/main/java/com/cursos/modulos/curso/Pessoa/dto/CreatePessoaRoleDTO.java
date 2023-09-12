package com.cursos.modulos.curso.Pessoa.dto;

import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class CreatePessoaRoleDTO {

    private Integer id;

    private List<Integer> idsRoles;

}