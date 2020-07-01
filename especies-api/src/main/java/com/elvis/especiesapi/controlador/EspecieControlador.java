package com.elvis.especiesapi.controlador;

import com.elvis.especiesapi.dominio.Especie;
import com.elvis.especiesapi.repositorio.EspecieRepositorio;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EspecieControlador {

    @Autowired
    private EspecieRepositorio especieRepositorio;


    @ApiOperation(value = "", authorizations = { @Authorization(value="apiKey") })
    @GetMapping("/especie")
    public List<Especie> obtenerTodas() {
        return especieRepositorio.findAll();
    }

    @ApiOperation(value = "", authorizations = { @Authorization(value="apiKey") })
    @GetMapping("/especie/{id}")
    public Especie obtenerPorId(@PathVariable("id") Long id) {

        Optional<Especie> especieOptional = especieRepositorio.findById(id);
        return especieOptional.isPresent()?especieOptional.get():null;
    }

    @ApiOperation(value = "", authorizations = { @Authorization(value="apiKey") })
    @PostMapping("/especie")
    public Especie agregar(@RequestBody Especie especie) {
        Especie entidad = especieRepositorio.save(especie);
        return entidad;
    }

    @ApiOperation(value = "", authorizations = { @Authorization(value="apiKey") })
    @DeleteMapping("/especie/{id}")
    public void eliminar(@PathVariable("id") Long id) {
        this.especieRepositorio.deleteById(id);
    }

    @ApiOperation(value = "", authorizations = { @Authorization(value="apiKey") })
    @PutMapping("/especie")
    public void actualizar(@RequestBody Especie especie) {
        this.especieRepositorio.save(especie);
    }
}
