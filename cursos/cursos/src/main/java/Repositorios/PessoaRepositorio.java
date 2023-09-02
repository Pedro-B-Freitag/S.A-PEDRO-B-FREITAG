package Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import classes.Pessoa;

public interface PessoaRepositorio extends JpaRepository<Pessoa, Long> {
    
    
}