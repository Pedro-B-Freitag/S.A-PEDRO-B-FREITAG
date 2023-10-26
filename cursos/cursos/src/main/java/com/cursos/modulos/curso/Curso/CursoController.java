package com.cursos.modulos.curso.Curso;


import com.cursos.modulos.curso.Curso.Services.CursoService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.sql.rowset.serial.SerialException;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;
import javax.sql.rowset.serial.SerialBlob;

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
    public String mostrarFormCadastrarCurso(Model theModel) throws IOException, SerialException, SQLException{
        Curso oCurso = new Curso();


        theModel.addAttribute("curso", oCurso);

        return "Curso/curso-form";
    }

    @PostMapping("/save")
    public String saveCurso(@ModelAttribute("curso") Curso oCurso ,
                            HttpServletRequest request,
                            @RequestParam("imagem") MultipartFile file)
                            throws IOException , SerialException, SQLException {


        byte[] bytes = file.getBytes();
        Blob imagemBlob = new SerialBlob(bytes);
        oCurso.setImagem(imagemBlob);


        cursoService.save(oCurso);

        return "redirect:/cursos/list";
    }
    @GetMapping("/save")
    public ModelAndView addImage(){
        return new ModelAndView("addimage");
    }

    @GetMapping("/mostrarFormAtualizarCurso")
    public String mostrarFormAtualizarCurso(@RequestParam("cursoid")  int oId, Model theModel ){

        Curso oCurso = cursoService.findById(oId);

        theModel.addAttribute("curso", oCurso);


        return "curso/curso-form";

    }

    @GetMapping("/deletar")
    public String deletar(@RequestParam("cursoid") int oId){
        cursoService.deleteById(oId);

        return "redirect:/cursos/list";
    }


    @GetMapping("/display")
    public ResponseEntity<byte[]> displayImage(@RequestParam("id") Integer id) throws IOException, SQLException
    {
        Curso image = cursoService.findById(id);
        byte [] imageBytes = null;
        imageBytes = image.getImagem().getBytes(1,(int) image.getImagem().length());
        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(imageBytes);
    }

    // view All images
    @GetMapping("/")
    public ModelAndView home(){
        ModelAndView mv = new ModelAndView("index");
        List<Curso> imageList = cursoService.findAll();
        mv.addObject("imageList", imageList);
        return mv;
    }



}
