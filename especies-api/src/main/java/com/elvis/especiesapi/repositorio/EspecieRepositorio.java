package com.elvis.especiesapi.repositorio;

import com.elvis.especiesapi.dominio.Especie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EspecieRepositorio extends JpaRepository<Especie, Long>  {
}
