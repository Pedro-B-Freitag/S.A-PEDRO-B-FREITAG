package com.cursos.modulos.curso.Vaga.Services;

import com.cursos.modulos.curso.Vaga.Vaga;
import com.cursos.modulos.curso.Vaga.DAOs.VagaDAO;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VagaServiceImpl implements VagaService {

    private VagaDAO vagaDAO;

    @Autowired
    public VagaServiceImpl(VagaDAO aVagaDAO){
        vagaDAO = aVagaDAO;
    }

    @Override
    public List<Vaga> findAll() {
        return vagaDAO.findAll();
    }

    @Override
    public Vaga findById(int oId) {
        return vagaDAO.findById(oId);
    }

    @Transactional
    @Override
    public Vaga save(Vaga aVaga) {
        return vagaDAO.save(aVaga);
    }

    @Transactional
    @Override
    public void deleteById(int oId) {
        vagaDAO.deleteById(oId);
    }
}
