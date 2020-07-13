package com.elvis.especiesapi.controlador;

import com.elvis.especiesapi.dominio.Especie;
import com.elvis.especiesapi.repositorio.EspecieRepositorio;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import javafx.util.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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

    public Double getDistanceAverageBetweenThreePoints(int x1, int y1, int x2,int y2,int x3,int y3) {
        double distancia1 = Math.sqrt(Math.pow((x2-x1),2) + Math.pow((y2-y1), 2));
        double distancia2 = Math.sqrt(Math.pow((x3-x1),2) + Math.pow((y3-y1), 2));
        double distancia3 = Math.sqrt(Math.pow((x3-x2),2) + Math.pow((y3-y2), 2));
        return (distancia1+distancia2+distancia3)/3;
    }

    public boolean IsCasiPalindromo(String palabra) {
        char result[] = new char[palabra.length()];
        int b = 0;
        for (int i = palabra.toCharArray().length - 1 ; i <= 0; i--) {
            result[b] = palabra.charAt(i);
            b++;
        }
        int count = 0;
        for (int i = 0; i < palabra.toCharArray().length; i++) {
            if (result[i] == palabra.charAt(i)) {
                count++;
            }
        }

        return palabra.toCharArray().length - count <= 1;

    }

    public int NumMasPopular(int numeros[]){
        List<Pair<Integer,Integer>> listaNumerosPopulares = new ArrayList<Pair<Integer,Integer>>();
        List<Pair<Integer,Integer>> listaNumerosPopularesRespuesta = new ArrayList<Pair<Integer,Integer>>();
        int veces = 0;
        for (int i=0; i<numeros.length;i++){
            veces = 0;
            for (int j = 0; j<numeros.length; j++) {
                if (i != j){
                    if (numeros[i] == numeros[j]) {
                        veces++;
                    }
                }
            }
            listaNumerosPopulares.add(new Pair<Integer, Integer>(numeros[i], veces));
        }
        int vecesQueAparece = listaNumerosPopulares.get(0).getValue();
        for (int i =0; i<listaNumerosPopulares.size(); i++) {
            if (listaNumerosPopulares.get(i).getValue() > vecesQueAparece) {
                vecesQueAparece = listaNumerosPopulares.get(i).getValue();
            }
        }

        for (int i =0; i<listaNumerosPopulares.size(); i++) {
            if (listaNumerosPopulares.get(i).getValue() == vecesQueAparece)
                listaNumerosPopularesRespuesta.add(new Pair<Integer, Integer>(listaNumerosPopulares.get(i).getKey(), veces));
        }

        if (listaNumerosPopularesRespuesta.size() == 1){
            return listaNumerosPopularesRespuesta.get(1).getKey();
        }
        else {
            int menorNumero = 0;
            for (int i =0; i<listaNumerosPopularesRespuesta.size(); i++) {
                if (menorNumero == 0){
                    menorNumero = listaNumerosPopularesRespuesta.get(i).getKey();
                }

                if (listaNumerosPopularesRespuesta.get(i).getKey() < menorNumero)
                    menorNumero = listaNumerosPopularesRespuesta.get(i).getKey();
            }

            return menorNumero;
        }
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
