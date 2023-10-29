package com.cursos.modulos.curso.Curso.Imagem.Services;

import com.cursos.modulos.curso.Curso.Imagem.Imagem;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.List;

@Service
public interface ImagemService {
    public Imagem create(Imagem imagem);
    public List<Imagem> viewAll();
    public Imagem viewById(Integer id);
}