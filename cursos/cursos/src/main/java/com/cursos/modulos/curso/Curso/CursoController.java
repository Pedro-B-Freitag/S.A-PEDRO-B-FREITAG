package com.cursos.modulos.curso.Curso;


import com.cursos.modulos.curso.Curso.Curso_Imagem.Imagem;
import com.cursos.modulos.curso.Curso.Curso_Imagem.Services.ImagemService;
import com.cursos.modulos.curso.Curso.Services.CursoService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.sql.rowset.serial.SerialException;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Base64;
import java.util.List;

@Controller
@RequestMapping("/cursos")
public class CursoController {
    private CursoService cursoService;
    @Autowired
    public CursoController(CursoService oCursoService){
        cursoService = oCursoService;
    }
    @Autowired
    private ImagemService imagemService;

    @GetMapping("/list")
    public String listCursos(Model theModel){
        List<Curso> osCursos = cursoService.findAll();
        theModel.addAttribute("curso", osCursos);
        return "curso/list-cursos";
    }

    @GetMapping("/listar")
    public ModelAndView home(){
        ModelAndView mv = new ModelAndView("index");
        List<Curso> imageList = cursoService.findAll();
        mv.addObject("imageList", imageList);
        return mv;
    }

    @GetMapping("/display")
    public ResponseEntity<byte[]> displayImage(@RequestParam("id") Integer oId) throws IOException, SQLException {
        Curso curso = cursoService.findById(oId);
        byte [] imageBytes = null;
        imageBytes = curso.getImage().getBytes(1,(int) curso.getImage().length());
        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(imageBytes);
    }


    @GetMapping("/listarTodos")
    public List<Curso> getAllProducts() {
        return cursoService.findAll();
    }


    @GetMapping("/addImage")
    public ModelAndView addImage(){
        return new ModelAndView("addimage");
    }

    @PostMapping("/addImage")
    public String addImagePost(HttpServletRequest request, @RequestParam("imagem") MultipartFile file) throws IOException, SerialException, SQLException
    {
        byte[] bytes = file.getBytes();
        Blob blob = new javax.sql.rowset.serial.SerialBlob(bytes);

        Curso curso = new Curso();
        curso.setImage(blob);
        cursoService.save(curso);
        return "redirect:/cursos/list ";
    }

    @GetMapping("/mostrarFormCadastrarCurso")
    public String mostrarFormCadastrarCurso(Model theModel){
        Curso oCurso = new Curso();

        theModel.addAttribute("curso", oCurso);

        return "Curso/curso-form";
    }

    @PostMapping("/save")
    public String saveCurso(@ModelAttribute("curso") Curso oCurso) {

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
