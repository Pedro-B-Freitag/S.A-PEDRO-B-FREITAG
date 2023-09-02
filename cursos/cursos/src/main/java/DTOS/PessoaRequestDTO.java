package DTOS;

import java.sql.Date;

public record PessoaRequestDTO(Long pessoa_id,
                               String  pessoa_cpf,
                               String  nome_pessoa,
                               Integer contato_pessoa,
                               String  pessoa_email,
                               String  pessoa_genero,
                               Date  data_nascimento,
                               String  cep_pessoa,
                               String  rua_pessoa,
                               String  bairro_pessoa,
                               String  cidade_pessoa,
                               String  estado_pessoa,
                               Integer pessoa_nr_residencia,
                               String  usuario_pessoa,
                               String  senha_pessoa) {
    
}