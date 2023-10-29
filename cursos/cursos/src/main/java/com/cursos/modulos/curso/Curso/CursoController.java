package com.cursos.modulos.curso.Curso;

import com.cursos.modulos.curso.Curso.Imagem.Imagem;
import com.cursos.modulos.curso.Curso.Imagem.Services.ImagemService;
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
    private ImagemService imagemService;

    @Autowired
    public CursoController(CursoService oCursoService){
        cursoService = oCursoService;
    }


    //CRUD DOS CURSOS
    @GetMapping("/list")
    public String listCursos(Model theModel){
        List<Curso> osCursos = cursoService.findAll();
        theModel.addAttribute("curso", osCursos);

        ModelAndView mv = new ModelAndView("list-cursos");
        List<Imagem> imageList = imagemService.viewAll();
        mv.addObject("imageList", imageList);

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
    ) throws SQLException {

        cursoService.save(oCurso);

        return "redirect:/cursos/list";
    }

    @GetMapping("/mostrarFormAtualizarCurso")
    public String mostrarFormAtualizarCurso(@RequestParam("cursoid") int oId, Model theModel){
        Curso oCurso = cursoService.findById(oId);
        theModel.addAttribute("cursoDTO", oCurso);
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

    // add image - post
    @PostMapping("/addImage")
    public String addImagePost(HttpServletRequest request,@RequestParam("imagem") MultipartFile file) throws IOException, SerialException, SQLException
    {
        byte[] bytes = file.getBytes();
        Blob blob = new javax.sql.rowset.serial.SerialBlob(bytes);

        Imagem imagem = new Imagem();
        imagem.setImagem(blob);
        imagemService.create(imagem);

        return "redirect:/cursos/mostrarFormCadastrarCurso";
    }
    @GetMapping("/display")
    public ResponseEntity<byte[]> displayImage(@RequestParam("id") Integer id) throws IOException, SQLException
    {
        Imagem imagem = imagemService.viewById(id);
        byte [] imageBytes = null;
        imageBytes = imagem.getImagem().getBytes(1,(int) imagem.getImagem().length());
        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(imageBytes);
    }

    @GetMapping("/")
    public ModelAndView home(){
        ModelAndView mv = new ModelAndView("list-cursos");
        List<Imagem> imageList = imagemService.viewAll();
        mv.addObject("imageList", imageList);
        return mv;
    }

}
