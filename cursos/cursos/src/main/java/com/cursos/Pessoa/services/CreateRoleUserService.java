package com.cursos.Pessoa.services;

import com.cursos.Pessoa.dto.CreatePessoaRoleDTO;
import com.cursos.Pessoa.entidade.Pessoa;
import com.cursos.Pessoa.entidade.Role;
import com.cursos.Pessoa.PessoaRepositorio;
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
        Optional<Pessoa> pessoaExiste = Optional.ofNullable(pessoaRepositorio.findById(createPessoaRoleDTO.getPessoaId()));

        List<Role> roles = new ArrayList<>();

        if(pessoaExiste.isEmpty()){
            throw new Error("Pessoa nao existe!!");
        }

        roles = createPessoaRoleDTO.getIdsRoles().stream().map(role ->{
            return new Role(role);
        }).collect(Collectors.toList());

        Pessoa pessoa = pessoaExiste.get();

        pessoa.setRoles(roles);

        pessoaRepositorio.save(pessoa);

        return(pessoa);
    }


}
