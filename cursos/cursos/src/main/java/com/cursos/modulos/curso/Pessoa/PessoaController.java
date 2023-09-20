package com.cursos.modulos.curso.Pessoa;

import com.cursos.modulos.curso.Empresa.Empresa;
import com.cursos.modulos.curso.Empresa.Service.EmpresaService;
import com.cursos.modulos.curso.Pessoa.Service.PessoaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/pessoas")
public class PessoaController {

    private PessoaService pessoaService;


    @Autowired
    public PessoaController(PessoaService aPessoaService){
        pessoaService = aPessoaService;
    }





    @GetMapping("/list")
    public String listPessoas(Model theModel){
        List<Pessoa> asPessoas = pessoaService.findAll();
        theModel.addAttribute("pessoa", asPessoas);

        return "pessoa/list-pessoas";
    }

    @GetMapping("/mostrarFormCadastrarPessoa")
    public String mostrarFormCadastrarPessoa(Model theModel){
        Pessoa aPessoa = new Pessoa();

        theModel.addAttribute("pessoa", aPessoa);

        return "Pessoa/pessoa-form";
    }



    @PostMapping("/save")
    public String savePessoa(@ModelAttribute("pessoa") Pessoa aPessoa){
        pessoaService.save(aPessoa);

        return "redirect:/pessoas/list";
    }




    @GetMapping("/mostrarFormAtualizarPessoa")
    public String mostrarFormAtualizarPessoa(@RequestParam("pessoaid") int oId, Model theModel){

        Pessoa aPessoa = pessoaService.findById(oId);

        theModel.addAttribute("pessoa", aPessoa);


        return "pessoa/pessoa-form";

    }


    @GetMapping("/deletar")
    public String deletar(@RequestParam("pessoaid") int oId){
        pessoaService.deleteById(oId);

        return "redirect:/pessoas/list";
    }




}
