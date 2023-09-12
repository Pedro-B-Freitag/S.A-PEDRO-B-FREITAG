package com.cursos.Pessoa.entidade;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "roles")
@AllArgsConstructor
@NoArgsConstructor
@Data

public class Role {

    @Id
    @GeneratedValue

    private UUID id;
    private String nome;

    public Role (UUID id){
        this.id = id;
    }
}
