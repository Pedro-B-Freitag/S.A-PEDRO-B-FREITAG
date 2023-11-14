package com.cursos.modulos.curso.Usuario.Service;

import com.cursos.modulos.curso.Usuario.DAOs.UsuarioDAO;
import com.cursos.modulos.curso.Pessoa.Pessoa;
import com.cursos.modulos.curso.Usuario.Usuario;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {


    private UsuarioDAO usuarioDAO;


    @Autowired
    public UsuarioServiceImpl(UsuarioDAO oUsuarioDAO){
        usuarioDAO = oUsuarioDAO;
    }


    @Override
    public List<Usuario> findAll() {
        return usuarioDAO.findAll();
    }

    @Override
    public Usuario findById(int oId) {
        return usuarioDAO.findById(oId);
    }

    @Transactional
    @Override
    public Usuario save(Usuario oUsuario) {
        return usuarioDAO.save(oUsuario);
    }

    @Transactional
    @Override
    public void deleteById(int oId) {
        usuarioDAO.deleteById(oId);
    }
}
