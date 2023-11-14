package com.cursos.modulos.curso.Usuario;

import com.cursos.modulos.curso.Pessoa.Pessoa;
import com.cursos.modulos.curso.Usuario.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/pessoas")
public class PessoaController {

    private UsuarioService usuarioService;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public PessoaController(UsuarioService pessoaService, PasswordEncoder passwordEncoder) {
        this.usuarioService = usuarioService;
        this.passwordEncoder = passwordEncoder;
    }






    @GetMapping("/list")
    public String listUsuarios(Model theModel){
        List<Usuario> osUsuarios = usuarioService.findAll();
        theModel.addAttribute("usuario", osUsuarios);

        return "pessoa/list-pessoas";
    }

    @GetMapping("/mostrarFormCadastrarPessoa")
    public String mostrarFormCadastrarPessoa(Model theModel){
        Usuario oUsuario = new Usuario();

        theModel.addAttribute("usuario", oUsuario);

        return "pessoa/pessoa-form";
    }



    @PostMapping("/save")
    public String savePessoa(@ModelAttribute("usuario") Usuario oUsuario){
        String hashedPassword = passwordEncoder.encode(oUsuario.getSenha());
        oUsuario.setSenha(hashedPassword);

        usuarioService.save(oUsuario);

        return "redirect:/pessoas/list";
    }




    @GetMapping("/mostrarFormAtualizarPessoa")
    public String mostrarFormAtualizarPessoa(@RequestParam("usuarioid") int oId, Model theModel){

        Usuario oUsuario = usuarioService.findById(oId);

        theModel.addAttribute("usuario", oUsuario);


        return "pessoa/pessoa-form";

    }


    @GetMapping("/deletar")
    public String deletar(@RequestParam("usuarioid") int oId){
        usuarioService.deleteById(oId);

        return "redirect:/pessoas/list";
    }




}
