package com.cursos.controllers;


import com.cursos.domain.curso.Curso;
import com.cursos.Repositorios.CursoRepositorio;
import com.cursos.domain.curso.RequestCurso;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController()
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
            curso.setCursoDescricao(data.curso_descricao());
            curso.setCursoCategoria(data.curso_categoria());
            curso.setCursoFornecedor(data.curso_fornecedor());
            curso.setCursoNome(data.curso_nome());
            curso.setCursoUrl(data.curso_url());
            curso.setCursoPresencial(data.curso_presencial());
            curso.setCursoImg(data.curso_img());
            curso.setCursoVisualizacao(data.curso_visualizacao());
            curso.setCursoGostei(data.curso_gostei());
            curso.setCursoQtdHrs(data.curso_qtd_hrs());

            // Salvar o curso atualizado no banco de dados
            repository.save(curso);

            return ResponseEntity.ok(curso);
        } else {
            //busca a classe de dado nao encontrado
            throw new EntityNotFoundException();
        }
    }
    //deletar curso
    @DeleteMapping("/{cursoId}")
    public ResponseEntity deletarCurso(@PathVariable Integer cursoId){
        repository.deleteById(cursoId);
        return ResponseEntity.noContent().build();
    }

    //@GetMapping
    //public ResponseEntity SelecionaCursosPresenciais(){
        //var Cursos = repository.findAllByCursoPresencialTrue();
        //return ResponseEntity.ok(Cursos);
    //}

   // }

}
