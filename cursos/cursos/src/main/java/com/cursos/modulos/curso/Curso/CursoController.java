package com.cursos.modulos.curso.Curso;

import com.cursos.modulos.curso.Curso.DTOs.CursoDTO;
import com.cursos.modulos.curso.Curso.DTOs.idDTO;
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
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

@Controller
@RequestMapping("/cursos")
public class CursoController {
    private CursoService cursoService;
    @Autowired
    private idDTO idDTO;
    private CursoDTO cursoDTO;


    @Autowired
    public CursoController(CursoService oCursoService, CursoDTO cursoDTO){
        cursoService = oCursoService;
        this.cursoDTO = cursoDTO;
        this.idDTO = idDTO;
    }


    //CRUD DOS CURSOS
    @GetMapping("/list")
    public String listCursos(Model theModel){
        List<Curso> osCursos = cursoService.findAll();
        theModel.addAttribute("curso", osCursos);


        return "curso/list-cursos";
    }

    @GetMapping("/listarTodos")
    public List<Curso> getAllCursos() {
        return cursoService.findAll();
    }

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

        oCurso.getImagem().setImagem(cursoDTO.getImagem().getImagem());
        cursoService.save(oCurso);

        return "redirect:/cursos/list";
    }

    @GetMapping("/mostrarFormAtualizarCurso")
    public String mostrarFormAtualizarCurso(Model theModel){
        Curso oCurso = cursoService.findById(idDTO.getId());
        theModel.addAttribute("curso", oCurso);
        return "curso/curso-form";
    }

    @GetMapping("/deletar")
    public String deletar(@RequestParam("cursoid") int oId){
        cursoService.deleteById(oId);
        return "redirect:/cursos/list";
    }


    /*
    ============================================================================================================================================================
    ============================================================================================================================================================
    ============================================================================================================================================================
    ============================================================================================================================================================
    ============================================================================================================================================================
    ============================================================================================================================================================
     */



    //CRUD DAS IMAGENS
    @GetMapping("/addImage")
    public ModelAndView addImage(){
        return new ModelAndView("addimage");
    }

    @PostMapping("/addImage")
    public String addImagePost(HttpServletRequest request,@RequestParam("imagem") MultipartFile file) throws IOException, SerialException, SQLException
    {
        byte[] bytes = file.getBytes();
        Blob blob = new javax.sql.rowset.serial.SerialBlob(bytes);



        cursoDTO.setImagem(blob);

        return "redirect:/cursos/mostrarFormCadastrarCurso";
    }



    @GetMapping("/updateImage")
    public ModelAndView updateImage(@RequestParam("cursoid") Integer oId, Model theModel){
        idDTO.setId(oId);
        return new ModelAndView("updateimage");
    }

    @PostMapping("/updateImage")
    public String updateImage(HttpServletRequest request,@RequestParam("imagem") MultipartFile file) throws IOException, SerialException, SQLException
    {
        byte[] bytes = file.getBytes();
        Blob blob = new javax.sql.rowset.serial.SerialBlob(bytes);


        cursoDTO.setImagem(blob);

        return "redirect:/cursos/mostrarFormAtualizarCurso";
    }

    // add image - post


    @GetMapping("/display")
    public ResponseEntity<byte[]> displayImage(@RequestParam("imagemid") Integer id) throws IOException, SQLException
    {
        Curso curso = cursoService.findById(id);
        byte [] imageBytes = curso.getImagem().getImagem().getBytes(1, (int) curso.getImagem().getImagem().length());
        System.out.println(imageBytes);
        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(imageBytes);
    }


}
