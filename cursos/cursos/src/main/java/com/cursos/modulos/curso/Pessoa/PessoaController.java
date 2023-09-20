package com.cursos.modulos.curso.Pessoa;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PessoaController {
    @GetMapping("/cadastro")
    public String showForm(Model oModel){
        oModel.addAttribute("pessoa", new Pessoa());

        return "pessoa-form";
    }

    @PostMapping("/processForm")
    public String processForm(
            @Valid @ModelAttribute("pessoa") Pessoa aPessoa,
            BindingResult oBindingResult){

        if(oBindingResult.hasErrors()){
            return "pessoa-form";
        }
        else{
            return  "pessoa-confirmation";
        }

    }
}
