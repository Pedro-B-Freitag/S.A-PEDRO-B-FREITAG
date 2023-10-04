package com.cursos.modulos.curso.Vaga;
import com.cursos.modulos.curso.Empresa.DAOs.EmpresaDAO;
import com.cursos.modulos.curso.Empresa.Empresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;

@Component
public class StringToEmpresaConverter implements Converter<String, Empresa> {
    @Autowired
    private EmpresaDAO empresaDAO;

    @Override
    public Empresa convert(String id) {
        return empresaDAO.findById(Integer.parseInt(id));
    }
}