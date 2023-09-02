package classes;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "vaga")
@Entity(name = "vaga")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "vaga_id")


public class Vaga {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long    vaga_id;
    private String  vaga_descricao;
    private String  vaga_cargo;
    private Date    vaga_data_vaga;
    private Date    vaga_data_prazo;
    private String  vaga_categoria;
    private Integer vaga_quantidade;

    public Vaga(DTOS.VagaRequestDTO data){
        vaga_id = data.vaga_id();
        vaga_descricao = data.vaga_descricao();
        vaga_cargo = data.vaga_cargo();
        vaga_data_vaga = data.vaga_data_vaga();
        vaga_data_prazo = data.vaga_data_prazo();
        vaga_categoria = data.vaga_categoria();
        vaga_quantidade = data.vaga_quantidade();
    }
}
