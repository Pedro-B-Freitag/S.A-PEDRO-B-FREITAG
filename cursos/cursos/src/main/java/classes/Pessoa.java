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

@Table(name = "pessoas")
@Entity(name = "pessoa")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "pessoa_id")

public class Pessoa {


    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private     Long    pessoa_id;
    private     String  pessoa_cpf;
    private     String  nome_pessoa;
    private     Integer contato_pessoa;
    private     String  pessoa_email;
    private     String  pessoa_genero;
    private     Date    data_nascimento;
    private     String  cep_pessoa;
    private     String  rua_pessoa;
    private     String  bairro_pessoa;
    private     String  cidade_pessoa;
    private     String  estado_pessoa;
    private     Integer pessoa_nr_residencia;
    private     String  usuario_pessoa;
    private     String  senha_pessoa;


    public Pessoa(DTOS.PessoaRequestDTO data) {
        pessoa_id = data.pessoa_id();
        pessoa_cpf =data.pessoa_cpf();
        nome_pessoa = data.nome_pessoa();
        contato_pessoa = data.contato_pessoa();
        pessoa_email = data.pessoa_email();
        pessoa_genero = data.pessoa_genero();
        data_nascimento = data.data_nascimento();
        cep_pessoa = data.cep_pessoa();
        rua_pessoa = data.rua_pessoa();
        bairro_pessoa = data.bairro_pessoa();
        cidade_pessoa = data.cidade_pessoa();
        estado_pessoa = data.estado_pessoa();
        pessoa_nr_residencia = data.pessoa_nr_residencia();
        usuario_pessoa = data.usuario_pessoa();
        senha_pessoa = data.senha_pessoa();

    }
    

}