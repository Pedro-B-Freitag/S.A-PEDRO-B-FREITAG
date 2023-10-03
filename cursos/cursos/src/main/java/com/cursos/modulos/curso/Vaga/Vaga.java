package com.cursos.modulos.curso.Vaga;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "vaga")
@Getter
@Setter
public class Vaga {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "categoria")
    private String categoria;
    @Column(name = "empresa_nome")
    private String empresaNome;
    @Column(name = "cargo")
    private String cargo;
    @Column(name = "data_vaga")
    private String dataVaga;
    @Column(name = "data_prazo")
    private Boolean dataPrazo;
    @Column(name = "quantidade")
    private Integer quantidade;
    @JoinColumn(name = "pessoa_usuario")
    private Integer pessoaUsuario;
    @JoinColumn(name = "empresa_cnpj")
    private String empresaCnpj;



    public Vaga(){

    }

    public Vaga(String descricao, String categoria, String empresaNome, String cargo, String dataVaga, Boolean dataPrazo, Integer quantidade) {
        this.descricao = descricao;
        this.categoria = categoria;
        this.empresaNome = empresaNome;
        this.cargo = cargo;
        this.dataVaga = dataVaga;
        this.dataPrazo = dataPrazo;
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "Vaga{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                ", categoria='" + categoria + '\'' +
                ", empresaNome='" + empresaNome + '\'' +
                ", cargo='" + cargo + '\'' +
                ", dataVaga='" + dataVaga + '\'' +
                ", dataPrazo=" + dataPrazo +
                ", quantidade=" + quantidade +
                ", pessoaUsuario=" + pessoaUsuario +
                ", empresaCnpj='" + empresaCnpj + '\'' +
                '}';
    }
}
