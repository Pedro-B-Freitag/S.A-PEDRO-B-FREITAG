package com.cursos.modulos.curso.Curso;


import com.cursos.modulos.curso.Curso.Services.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/cursos")
public class CursoController {
    private CursoService cursoService;

    @Autowired
    public CursoController(CursoService oCursoService){
        cursoService = oCursoService;
    }



    @GetMapping("/list")
    public String listCursos(Model theModel){
        List<Curso> osCursos = cursoService.findAll();
        theModel.addAttribute("curso", osCursos);
        return "curso/list-cursos";
    }

    @GetMapping("/listarTodos")
    public List<Curso> getAllProducts() {
        return cursoService.findAll();
    }

    @GetMapping("/mostrarFormCadastrarCurso")
    public String mostrarFormCadastrarCurso(Model theModel){
        Curso oCurso = new Curso();

        theModel.addAttribute("curso", oCurso);

        return "Curso/curso-form";
    }

    @PostMapping("/save")
    public String saveCurso(@ModelAttribute("curso") Curso oCurso)  {
        cursoService.save(oCurso);

        return "redirect:/cursos/list";
    }

    @GetMapping("/mostrarFormAtualizarCurso")
    public String mostrarFormAtualizarCurso(@RequestParam("cursoid") int oId, Model theModel){

        Curso oCurso = cursoService.findById(oId);

        theModel.addAttribute("curso", oCurso);


        return "curso/curso-form";

    }

    @GetMapping("/deletar")
    public String deletar(@RequestParam("cursoid") int oId){
        cursoService.deleteById(oId);

        return "redirect:/cursos/list";
    }













}
