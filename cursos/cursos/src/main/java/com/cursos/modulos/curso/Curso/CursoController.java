package com.cursos.modulos.curso.Curso;

import com.cursos.modulos.curso.Curso.DTOs.CursoDTO;
import com.cursos.modulos.curso.Curso.Imagem.Imagem;
import com.cursos.modulos.curso.Curso.Services.CursoService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.sql.rowset.serial.SerialException;
import java.awt.*;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

@Controller
@RequestMapping("/cursos")
public class CursoController {

    private CursoService cursoService;
    private CursoDTO cursoDTO;

    private Imagem imagem;
    @Autowired
    public CursoController(CursoService oCursoService, CursoDTO cursoDTO, Imagem imagem){
        cursoService = oCursoService;
        this.cursoDTO = cursoDTO;
        this.imagem = imagem;
    }


    //CRUD DOS CURSOS
    @GetMapping("/list")
    public String listCursos(Model theModel){
        List<Curso> osCursos = cursoService.findAll();
        theModel.addAttribute("curso", osCursos);


        return "curso/list-cursos";
    }

    //DISPLAY IMAGENS
    @GetMapping("/display")
    public ResponseEntity<byte[]> displayImage(@RequestParam("imagemid") Integer id) throws IOException, SQLException
    {
        Curso curso = cursoService.findById(id);
        byte [] imageBytes = null;
        imageBytes = curso.getImagem().getBytes(1, (int) curso.getImagem().length());
        System.out.println(imageBytes);
        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(imageBytes);
    }


    @GetMapping("/listarTodos")
    public List<Curso> getAllCursos() {
        return cursoService.findAll();
    }


    //ADICIONAR IMAGEM
    @GetMapping("/addImage")
    public ModelAndView addImage(){
        return new ModelAndView("imagem/addimage");
    }

    @PostMapping("/addImage")
    public String addImagePost(HttpServletRequest request,@RequestParam("imagem") MultipartFile file) throws IOException, SerialException, SQLException
    {
        byte[] bytes = file.getBytes();
        Blob blob = new javax.sql.rowset.serial.SerialBlob(bytes);

        //Imagem imagem = new Imagem();
        imagem.setImagem(blob);

        cursoDTO.setImagem(imagem);

        return "redirect:/cursos/mostrarFormCadastrarCurso";
    }

    //ADICIONAR CURSO
    @GetMapping("/mostrarFormCadastrarCurso")
    public String mostrarFormCadastrarCurso(Model model, HttpServletRequest request) {

        Curso curso = new Curso();
        model.addAttribute("curso", curso);

        return "curso/curso-form";
    }

    @PostMapping("/save")
    public String saveCurso(
            HttpServletRequest request, RedirectAttributes redirectAttributes, @ModelAttribute("curso") Curso oCurso
    ) throws SQLException, IOException , SerialException {

        oCurso.setImagem(imagem.getImagem());
        cursoService.save(oCurso);

        return "redirect:/cursos/list";
    }


    //UPDATE IMAGEM

    @GetMapping("/updateImage")
    public ModelAndView updateImage(@RequestParam("cursoid") Integer id, Model theModel){
        return new ModelAndView("imagem/updateimage");
    }

    @PostMapping("/updateImage")
    public String updateImage(HttpServletRequest request, @RequestParam("imagem") MultipartFile file) throws IOException, SerialException, SQLException {

        Integer cursoId = Integer.valueOf(request.getParameter("cursoid"));

        byte[] bytes = file.getBytes();
        Blob blob = new javax.sql.rowset.serial.SerialBlob(bytes);

        //Imagem imagem = new Imagem();
        imagem.setImagem(blob);
        cursoDTO.setImagem(imagem);


        return "redirect:/cursos/mostrarFormAtualizarCurso?cursoid=" + cursoId;
    }


    @GetMapping("/mostrarFormAtualizarCurso")
    public String mostrarFormAtualizarCurso(@RequestParam("cursoid") Integer id, Model theModel){
        Curso oCurso = cursoService.findById(id);
        theModel.addAttribute("curso", oCurso);
        return "curso/update-curso";
    }

    @PostMapping("/saveUpdate")
    public String saveCursoUpdate(
            HttpServletRequest request, RedirectAttributes redirectAttributes, @ModelAttribute("curso") Curso oCurso
    ) throws SQLException, IOException , SerialException {

        oCurso.setImagem(imagem.getImagem());
        cursoService.save(oCurso);

        return "redirect:/cursos/list";
    }


    //DELETAR CURSO
    @GetMapping("/deletar")
    public String deletar(@RequestParam("cursoid") int oId){
        cursoService.deleteById(oId);
        return "redirect:/cursos/list";
    }




}
