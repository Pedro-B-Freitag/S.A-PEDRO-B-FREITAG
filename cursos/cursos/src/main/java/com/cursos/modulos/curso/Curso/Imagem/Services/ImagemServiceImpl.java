package com.cursos.modulos.curso.Curso.Imagem.Services;

import com.cursos.modulos.curso.Curso.Imagem.Imagem;
import com.cursos.modulos.curso.Curso.Imagem.ImagemDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImagemServiceImpl implements ImagemService {
    @Autowired
    private ImagemDAO imagemDAO;

    @Override
    public Imagem create(Imagem imagem) {
        return imagemDAO.save(imagem);
    }
    @Override
    public List<Imagem> viewAll() {
        return (List<Imagem>) imagemDAO.findAll();
    }
    @Override
    public Imagem viewById(Integer id) {
        return imagemDAO.findById(id).get();
    }
}