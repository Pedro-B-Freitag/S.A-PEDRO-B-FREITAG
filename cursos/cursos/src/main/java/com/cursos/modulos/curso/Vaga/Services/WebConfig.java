package com.cursos.modulos.curso.Vaga.Services;

import com.cursos.modulos.curso.Empresa.DAOs.EmpresaDAO;
import com.cursos.modulos.curso.Vaga.StringToEmpresaConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private StringToEmpresaConverter stringToEmpresaConverter;

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(stringToEmpresaConverter);
    }
}