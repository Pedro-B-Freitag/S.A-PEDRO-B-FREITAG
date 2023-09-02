package DTOS;

import java.sql.Blob;

public record EmpresaRequestDTO(
             Long    empresa_id,
             String  empresa_cnpj,
             String  empresa_nome,
             Integer empresa_cep,
             String  empresa_rua,
             String  empresa_bairro,
             String  empresa_cidade,
             String  empresa_estado,
             String  empresa_email,
             String  empresa_contato,
             Blob    empresa_logo
)
{}
