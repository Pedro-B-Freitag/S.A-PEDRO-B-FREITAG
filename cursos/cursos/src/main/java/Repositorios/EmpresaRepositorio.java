package Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import classes.Empresa;

public interface EmpresaRepositorio extends JpaRepository<Empresa, Long>  {
    
}
