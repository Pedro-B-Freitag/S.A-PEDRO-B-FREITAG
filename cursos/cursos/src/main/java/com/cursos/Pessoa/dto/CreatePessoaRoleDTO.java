package com.cursos.Pessoa.dto;

import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class CreatePessoaRoleDTO {

    private UUID pessoaId;

    private List<UUID> idsRoles;

}