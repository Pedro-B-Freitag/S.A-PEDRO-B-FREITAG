package classes;

import java.sql.Blob;

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

@Table(name = "empresa")
@Entity(name = "empresa")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "empresa_id")


public class Empresa {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        private     Long    empresa_id;
        private     String  empresa_cnpj;
        private     String  empresa_nome;
        private     Integer empresa_cep;
        private     String  empresa_rua;
        private     String  empresa_bairro;
        private     String  empresa_cidade;
        private     String  empresa_estado;
        private     String  empresa_email;
        private     String  empresa_contato;
        private     Blob    empresa_logo;

        public Empresa(DTOS.EmpresaRequestDTO data){
            empresa_id =      data.empresa_id();
            empresa_cnpj =    data.empresa_cnpj();
            empresa_nome =    data.empresa_nome();
            empresa_cep =     data.empresa_cep();
            empresa_rua =     data.empresa_rua();
            empresa_bairro =  data.empresa_bairro();
            empresa_cidade =  data.empresa_cidade();
            empresa_estado =  data.empresa_estado();
            empresa_email =   data.empresa_email();
            empresa_contato = data.empresa_contato();
            empresa_logo =    data.empresa_logo();
        }
    
}
