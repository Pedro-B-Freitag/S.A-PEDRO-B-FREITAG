package com.cursos.modulos.curso.Curso;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("curso")

public class CursoController {

    @Autowired
    private CursoRepositorio repository;
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public void salvarCurso(@RequestBody CursoRequestDTO data){
        Curso cursoData = new Curso(data);
        repository.save(cursoData);
        return;
    }
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public List<CursoResponseDTO> getAll(){

        List<CursoResponseDTO> cursoList = repository.findAll().stream().map(CursoResponseDTO::new).toList();
        return cursoList;

    }

}
