package com.cursos.modulos.curso.Empresa.Service;

import com.cursos.modulos.curso.Empresa.Empresa;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public interface EmpresaService {

    List<Empresa> findAll();
    Empresa findById(int oId);
    Empresa save(Empresa aEmpresa);
    void deleteById(int oId);

}
