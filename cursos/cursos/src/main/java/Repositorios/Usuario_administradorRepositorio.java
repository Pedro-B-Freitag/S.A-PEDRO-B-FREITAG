package Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import classes.Usuario_administrador;

public interface Usuario_administradorRepositorio extends JpaRepository<Usuario_administrador, Long> {
    
    
}