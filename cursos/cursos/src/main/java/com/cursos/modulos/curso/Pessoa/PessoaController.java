package com.cursos.modulos.curso.Pessoa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    CreatePessoaService createPessoaService;

    @PostMapping("/create")
    public Pessoa create(@RequestBody Pessoa pessoa){

        return createPessoaService.execute(pessoa);
    }



}
