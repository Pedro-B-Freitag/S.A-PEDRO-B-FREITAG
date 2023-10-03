package com.cursos.modulos.curso.Vaga;

import com.cursos.modulos.curso.Empresa.Empresa;
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
    @ManyToOne
    @JoinColumn(name = "empresa_nome")
    private Empresa empresa;
    @Column(name = "cargo")
    private String cargo;
    @Column(name = "data_vaga")
    private String dataVaga;
    @Column(name = "data_prazo")
    private String dataPrazo;
    @Column(name = "quantidade")
    private String quantidade;

    @Column(name = "url")
    private String url;


    public Vaga(){

    }

    public Vaga(String descricao, String categoria, Empresa empresa, String cargo, String dataVaga, String dataPrazo, String quantidade, String url) {
        this.descricao = descricao;
        this.categoria = categoria;
        this.empresa = empresa;
        this.cargo = cargo;
        this.dataVaga = dataVaga;
        this.dataPrazo = dataPrazo;
        this.quantidade = quantidade;
        this.url = url;
    }

    @Override
    public String toString() {
        return "Vaga{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                ", categoria='" + categoria + '\'' +
                ", empresa='" + empresa + '\'' +
                ", cargo='" + cargo + '\'' +
                ", dataVaga='" + dataVaga + '\'' +
                ", dataPrazo=" + dataPrazo +
                ", quantidade=" + quantidade +
                ", url='" + url + '\'' +
                '}';
    }
}