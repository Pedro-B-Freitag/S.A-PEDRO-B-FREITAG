package Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import classes.Vaga;

public interface VagaRepositorio extends JpaRepository<Vaga, Long> {
    
    
}