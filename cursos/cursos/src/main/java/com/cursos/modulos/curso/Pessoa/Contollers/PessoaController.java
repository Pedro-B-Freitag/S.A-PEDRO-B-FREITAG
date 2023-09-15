package com.cursos.modulos.curso.Pessoa.Contollers;

import com.cursos.modulos.curso.Pessoa.dto.CreatePessoaRoleDTO;
import com.cursos.modulos.curso.Pessoa.entidades.Pessoa;
import com.cursos.modulos.curso.Pessoa.services.CreatePessoaService;
import com.cursos.modulos.curso.Pessoa.services.CreateRoleUserService;
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

    @Autowired
    CreateRoleUserService createRoleUserService;
    @PostMapping("/create")
    public Pessoa create(@RequestBody Pessoa pessoa){

        return createPessoaService.execute(pessoa);
    }

    @PostMapping("/role")
    public Pessoa role(@RequestBody CreatePessoaRoleDTO createPessoaRoleDTO){
        return createRoleUserService.execute(createPessoaRoleDTO);
    }


}
