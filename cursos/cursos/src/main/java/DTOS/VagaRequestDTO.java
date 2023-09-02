package DTOS;

import java.sql.Date;

public record VagaRequestDTO(Long    vaga_id,
                             String  vaga_descricao,
                             String  vaga_cargo,
                             Date    vaga_data_vaga,
                             Date    vaga_data_prazo,
                             String  vaga_categoria,
                             Integer vaga_quantidade

) {
    
}
