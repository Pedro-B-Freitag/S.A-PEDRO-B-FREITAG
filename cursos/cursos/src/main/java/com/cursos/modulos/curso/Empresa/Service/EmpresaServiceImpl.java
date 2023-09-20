package com.cursos.modulos.curso.Empresa.Service;

import com.cursos.modulos.curso.Curso.DAOs.CursoDAO;
import com.cursos.modulos.curso.Empresa.DAOs.EmpresaDAO;
import com.cursos.modulos.curso.Empresa.Empresa;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmpresaServiceImpl implements EmpresaService{


    private EmpresaDAO empresaDAO;

    @Autowired
    public EmpresaServiceImpl(EmpresaDAO aEmpresaDAO){
        empresaDAO = aEmpresaDAO;
    }


    @Override
    public List<Empresa> findAll() {
        return empresaDAO.findAll();
    }

    @Override
    public Empresa findById(int oId) {
        return empresaDAO.findById(oId);
    }

    @Transactional
    @Override
    public Empresa save(Empresa aEmpresa) {
        return empresaDAO.save(aEmpresa);
    }

    @Transactional
    @Override
    public void deleteById(int oId) {
        empresaDAO.deleteById(oId);
    }
}
