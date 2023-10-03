package com.cursos.modulos.curso.Vaga;


import com.cursos.modulos.curso.Vaga.Services.VagaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/vagas")
public class VagaController {
    private VagaService cursoService;

    @Autowired
    public VagaController(VagaService oCursoService){
        cursoService = oCursoService;
    }



    @GetMapping("/list")
    public String listCursos(Model theModel){
        List<Vaga> osCursos = cursoService.findAll();
        theModel.addAttribute("curso", osCursos);
        return "curso/list-cursos";
    }

    @GetMapping("/listarTodos")
    public List<Vaga> getAllProducts() {
        return cursoService.findAll();
    }

    @GetMapping("/mostrarFormCadastrarVaga")
    public String mostrarFormCadastrarCurso(Model theModel){
        Vaga oCurso = new Vaga();

        theModel.addAttribute("curso", oCurso);

        return "Curso/curso-form";
    }

    @PostMapping("/save")
    public String saveCurso(@ModelAttribute("curso") Vaga oCurso){
        cursoService.save(oCurso);

        return "redirect:/cursos/list";
    }

    @GetMapping("/mostrarFormAtualizarVaga")
    public String mostrarFormAtualizarCurso(@RequestParam("cursoid") int oId, Model theModel){

        Vaga oCurso = cursoService.findById(oId);

        theModel.addAttribute("curso", oCurso);


        return "curso/curso-form";

    }

    @GetMapping("/deletar")
    public String deletar(@RequestParam("cursoid") int oId){
        cursoService.deleteById(oId);

        return "redirect:/cursos/list";
    }












}
