package com.cursos.controllers;


import com.cursos.domain.curso.Curso;
import com.cursos.domain.curso.CursoRepositorio;
import com.cursos.domain.curso.RequestCurso;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.sql.Blob;
import java.sql.Time;
import java.util.Optional;

@RestController
@RequestMapping("/curso")
public class CursoController {
    @Autowired
    //cria uma instancia da dependencia
    private CursoRepositorio repository;
    @GetMapping
    //mostra todos os cursos
    public ResponseEntity SelecionaTodosOsCursos(){
        var Cursos = repository.findAll();
        return ResponseEntity.ok(Cursos);
    }

    //adicionar curso
    @PostMapping
    //recebe dados por parametro
    public ResponseEntity registrarCurso(@RequestBody @Validated RequestCurso data ){
        Curso novoCurso = new Curso(data);
        repository.save(novoCurso);

        //retorna um corpo sem nada, por isso utilizado o build
        return ResponseEntity.ok().build();
    }


    //PutMapping utilizado para atualizar um dado a partir do id
    @PutMapping
    //indica que acontece uma trasacao, quando executamos mais de uma operacao em conjunto e finalizadas,
    //atualizamos todas as colunas ao mesmo tempo
    @Transactional
    public ResponseEntity atualizarCurso(@RequestBody @Validated RequestCurso data) {
        Optional<Curso> cursoOptional = repository.findById(data.curso_id());

        //analiza se o o curso esta presente, se retornou
        if (cursoOptional.isPresent()) {
            Curso curso = cursoOptional.get();

            // Atualizar os campos do curso com os valores fornecidos
            curso.setCurso_descricao(data.curso_descricao());
            curso.setCurso_categoria(data.curso_categoria());
            curso.setCurso_fornecedor(data.curso_fornecedor());
            curso.setCurso_nome(data.curso_nome());
            curso.setCurso_url(data.curso_url());
            curso.setCurso_presencial(data.curso_presencial());
            curso.setCurso_img(data.curso_img());
            curso.setCurso_visualizacao(data.curso_visualizacao());
            curso.setCurso_gostei(data.curso_gostei());
            curso.setCurso_qtd_hrs(data.curso_qtd_hrs());

            // Salvar o curso atualizado no banco de dados
            repository.save(curso);

            return ResponseEntity.ok(curso);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
