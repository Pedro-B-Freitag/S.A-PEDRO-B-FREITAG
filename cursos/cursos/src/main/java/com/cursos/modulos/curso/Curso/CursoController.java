package com.cursos.modulos.curso.Curso;

import com.cursos.modulos.curso.Curso.Services.CursoService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import jakarta.servlet.http.HttpSession;
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
    public ModelAndView addImage(Model model){
        return new ModelAndView("addimage");
    }

    @PostMapping("/addImage")
    public String addImagePost(HttpServletRequest request,RedirectAttributes redirectAttributes, @RequestParam("imagem") MultipartFile file) throws IOException, SerialException, SQLException
    {
        byte[] bytes = file.getBytes();

        // Log the length of the byte array
        System.out.println("Length of the byte array: " + bytes.length);

        Blob blob = new javax.sql.rowset.serial.SerialBlob(bytes);

        Curso curso = new Curso();
        curso.setImage(blob);

        System.out.println("Setting curso object in flash attribute: " + curso);
        redirectAttributes.addFlashAttribute("curso", curso);
        request.getSession().setAttribute("cursoSession", curso);

        return "redirect:/cursos/mostrarFormCadastrarCurso";
    }

    @GetMapping("/mostrarFormCadastrarCurso")
    public String mostrarFormCadastrarCurso(Model model, HttpServletRequest request){

        Curso oCurso = new Curso();
        model.addAttribute("curso", oCurso);

        // Log additional information for debugging
        System.out.println("Model attributes before retrieving curso: " + model.asMap());

        System.out.println("Setting curso object in model attribute: " + oCurso);

        model.addAttribute("curso", oCurso);



        return "curso/curso-form";
    }

    @PostMapping("/save")
    public String saveCurso(HttpServletRequest request) {
        Curso oCurso = (Curso) request.getSession().getAttribute("cursoSession");

        // Check if oCurso is not null before saving
            cursoService.save(oCurso);
            System.out.println("Enviando: " + oCurso);

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