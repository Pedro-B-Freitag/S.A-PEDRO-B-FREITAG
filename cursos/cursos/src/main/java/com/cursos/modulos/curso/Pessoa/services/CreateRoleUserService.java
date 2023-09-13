package com.cursos.modulos.curso.Pessoa.services;

import com.cursos.modulos.curso.Pessoa.dto.CreatePessoaRoleDTO;
import com.cursos.modulos.curso.Pessoa.entidades.Pessoa;
import com.cursos.modulos.curso.Pessoa.entidades.Role;
import com.cursos.modulos.curso.Pessoa.PessoaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CreateRoleUserService {
    @Autowired
    PessoaRepositorio pessoaRepositorio;

    public Pessoa execute(CreatePessoaRoleDTO createPessoaRoleDTO){

        Optional<Pessoa> pessoaExiste = (pessoaRepositorio.findById(createPessoaRoleDTO.getIdPessoa()));
        List<Role> roles = new ArrayList<>();

        if(pessoaExiste.isEmpty()){
            throw new Error("Pessoa nao existe!!");
        }

        roles = createPessoaRoleDTO.getIdRole().stream().map(role-> new Role(role)).collect(Collectors.toList());

        Pessoa pessoa = pessoaExiste.get();

        pessoa.setRoles(roles);

        pessoaRepositorio.save(pessoa);

        return(pessoa);
    }


}
