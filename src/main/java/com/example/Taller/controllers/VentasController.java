package com.example.Taller.controllers;

import com.example.Taller.entities.Concesionario;
import com.example.Taller.entities.Ventas;
import com.example.Taller.responses.ResponseHandler;
import com.example.Taller.services.ConcesionarioService;
import com.example.Taller.services.VentasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("ventas")
public class VentasController {
    @Autowired
    private VentasService ventasService;
    @Autowired
    private ConcesionarioService concesionarioService;

    @GetMapping
    public ResponseEntity<Object> findAll(){
        try{
            List<Ventas> result = ventasService.findAll();
            return ResponseHandler.generateResponse("Success", HttpStatus.OK,result);
        }catch (Exception e){
            return ResponseHandler.generateResponse(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR,null);
        }
    }

    @PostMapping("/{id}")
    public ResponseEntity<Object> save(@RequestBody Ventas ventas, @PathVariable Integer id) {
        try {
            Concesionario concesionario = concesionarioService.findById(id);
            if (concesionario != null) {
                List<Concesionario> concesionarios = new ArrayList<>();
                concesionarios.add(concesionario);
                Ventas result = ventasService.save(ventas, concesionarios);
                return ResponseHandler.generateResponse("Success", HttpStatus.CREATED, result);
            }
            return ResponseHandler.generateResponse("Concesionario not found", HttpStatus.NOT_FOUND, null);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Integer id){
        try{
            Ventas ventas = ventasService.findById(id);
            if (ventas != null){
                ventasService.delete(ventas);
                return ResponseHandler.generateResponse("Success",HttpStatus.ACCEPTED,ventas);
            }
            return ResponseHandler.generateResponse("Success Concesionario",HttpStatus.NOT_FOUND,null);
        }catch (Exception e){
            return ResponseHandler.generateResponse(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR,null);
        }
    }



















}
