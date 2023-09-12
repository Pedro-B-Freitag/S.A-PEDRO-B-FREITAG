package com.cursos.modulos.curso.Pessoa.entidades;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "roles")
@AllArgsConstructor
@NoArgsConstructor
@Data

public class Role {

    @Id
    @GeneratedValue

    private Integer id;
    private String  nome;

    public Role (Integer id){
        this.id = id;
    }
}
