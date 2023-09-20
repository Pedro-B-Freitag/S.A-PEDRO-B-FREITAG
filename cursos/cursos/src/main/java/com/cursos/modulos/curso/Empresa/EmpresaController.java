package com.cursos.modulos.curso.Empresa;


import com.cursos.modulos.curso.Curso.Curso;
import com.cursos.modulos.curso.Curso.Services.CursoService;
import com.cursos.modulos.curso.Empresa.Service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/empresas")
public class EmpresaController {

    private EmpresaService empresaService;


    @Autowired
    public EmpresaController(EmpresaService aEmpresaService){
        empresaService = aEmpresaService;
    }


    @GetMapping("/list")
    public String listEmpresas(Model theModel){
        List<Empresa> asEmpresas = empresaService.findAll();
        theModel.addAttribute("empresa", asEmpresas);
        return "empresa/list-empresas";
    }

    @GetMapping("/mostrarFormCadastrarEmpresa")
    public String mostrarFormCadastrarEmpresa(Model theModel){
        Empresa aEmpresa = new Empresa();

        theModel.addAttribute("empresa", aEmpresa);

        return "Empresa/empresa-form";
    }


    @PostMapping("/save")
    public String saveEmpresa(@ModelAttribute("empresa") Empresa aEmpresa){
        empresaService.save(aEmpresa);

        return "redirect:/empresas/list";
    }


    @GetMapping("/mostrarFormAtualizarEmpresa")
    public String mostrarFormAtualizarEmpresa(@RequestParam("empresaid") int oId, Model theModel){

        Empresa aEmpresa = empresaService.findById(oId);

        theModel.addAttribute("empresa", aEmpresa);


        return "empresa/empresa-form";

    }

    @GetMapping("/deletar")
    public String deletar(@RequestParam("empresaid") int oId){
        empresaService.deleteById(oId);

        return "redirect:/empresas/list";
    }



}
