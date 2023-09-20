package com.cursos.modulos.curso.Empresa.DAOs;

import com.cursos.modulos.curso.Curso.Curso;
import com.cursos.modulos.curso.Empresa.Empresa;

import java.util.List;

public interface EmpresaDAO {
    List<Empresa> findAll();
    Empresa findById(int oId);
    Empresa save(Empresa aEmpresa);
    void deleteById(int oId);
}
