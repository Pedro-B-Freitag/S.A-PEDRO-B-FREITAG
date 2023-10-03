package com.cursos.modulos.curso.Vaga;


import com.cursos.modulos.curso.Empresa.DAOs.EmpresaDAO;
import com.cursos.modulos.curso.Empresa.Empresa;
import com.cursos.modulos.curso.Empresa.Service.EmpresaService;
import com.cursos.modulos.curso.Vaga.Services.VagaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/vagas")
public class VagaController {
    @Autowired
    private VagaService vagaService;
    @Autowired
    private EmpresaDAO empresaDAO;

    @Autowired
    public VagaController(VagaService aVagaService){
        vagaService = aVagaService;
    }



    @GetMapping("/list")
    public String listVagas(Model theModel){
        List<Vaga> asVagas = vagaService.findAll();
        theModel.addAttribute("vaga", asVagas);
        return "Vaga/list-vaga";
    }


    @GetMapping("/mostrarFormCadastrarVaga")
    public String mostrarFormCadastrarVaga(Model theModel){
        Vaga aVaga = new Vaga();

        theModel.addAttribute("vaga", aVaga);

        List<Empresa> listempresa = empresaDAO.findAll();
        theModel.addAttribute("listempresa", listempresa);

        return "Vaga/vaga-form";
    }

    @PostMapping("/save")
    public String saveVaga(@ModelAttribute("vaga") Vaga aVaga){
        vagaService.save(aVaga);

        return "redirect:/vagas/list";
    }

    @GetMapping("/mostrarFormAtualizarVaga")
    public String mostrarFormAtualizarVaga(@RequestParam("vagaid") int oId, Model theModel){

        Vaga aVaga = vagaService.findById(oId);
        theModel.addAttribute("vaga", aVaga);


        return "vaga/vaga-form";

    }

    @GetMapping("/deletar")
    public String deletar(@RequestParam("vagaid") int oId){
        vagaService.deleteById(oId);

        return "redirect:/vagas/list";
    }











}
