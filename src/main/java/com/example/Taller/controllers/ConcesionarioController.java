package com.example.Taller.controllers;

import com.example.Taller.entities.Vehiculo;
import com.example.Taller.entities.Ventas;
import com.example.Taller.services.ConcesionarioService;
import com.example.Taller.entities.Concesionario;
import com.example.Taller.responses.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/concesionario")
public class ConcesionarioController {
    @Autowired
    private ConcesionarioService concesionarioService;

    @GetMapping()
    public ResponseEntity<Object> findAll(){
        try {
            List<Concesionario> result = concesionarioService.findAll();
            return ResponseHandler.generateResponse("Success", HttpStatus.OK,result);
        }catch (Exception e){
            return ResponseHandler.generateResponse(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR,null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable Integer id){
        try{
            Concesionario concesionario = concesionarioService.findById(id);
            return ResponseHandler.generateResponse("Success",HttpStatus.OK,concesionario);
        }catch (Exception e){
            return ResponseHandler.generateResponse(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR,null);
        }
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody Concesionario concesionario){
        try{
            Concesionario result = concesionarioService.save(concesionario);
            return ResponseHandler.generateResponse("Success",HttpStatus.CREATED,result);
        }catch (Exception e){
            return ResponseHandler.generateResponse(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR,null);
        }
    }

    @GetMapping("/country/{country}")
    public ResponseEntity<Object> findByCountry(@PathVariable String country){
        try{
            List<Concesionario> result = concesionarioService.findByCountry(country);
            return ResponseHandler.generateResponse("Success",HttpStatus.OK,result);
        }catch (Exception e){
            return ResponseHandler.generateResponse(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR,null);
        }
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<Object> findByName(@PathVariable String name){
        try{
            List<Concesionario> result = concesionarioService.findByName(name);
            return ResponseHandler.generateResponse("Success",HttpStatus.OK,result);
        }catch (Exception e){
            return ResponseHandler.generateResponse(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR,null);
        }
    }

    @GetMapping("/vehiculos/{id}")
    public ResponseEntity<Object> getVehiculos(@PathVariable Integer id){
        try {
            Concesionario concesionario = concesionarioService.findById(id);
            if (concesionario != null){
                List<Vehiculo> result = concesionarioService.getVehiculos(concesionario);
                return ResponseHandler.generateResponse("Success",HttpStatus.CREATED,result);
            }
            return ResponseHandler.generateResponse("Success concesionario",HttpStatus.NOT_FOUND,null);
        }catch (Exception e){
            return ResponseHandler.generateResponse(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR,null);
        }
    }

    @GetMapping("/ventass/{id}")
    public ResponseEntity<Object> getVentass(@PathVariable Integer id){
        try {
            Concesionario concesionario = concesionarioService.findById(id);
            if (concesionario != null){
                List<Ventas> result = concesionarioService.getVentass(concesionario);
                return ResponseHandler.generateResponse("Succes",HttpStatus.CREATED, result );
            }
            return ResponseHandler.generateResponse("Success concesionario",HttpStatus.NOT_FOUND,null);
        }catch (Exception e){
            return ResponseHandler.generateResponse(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR,null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Integer id){
        try {
            Concesionario concesionario = concesionarioService.findById(id);
            if (concesionario != null){
                concesionarioService.delete(concesionario);
                return ResponseHandler.generateResponse("Success",HttpStatus.ACCEPTED,concesionario);
            }
            return ResponseHandler.generateResponse("Success Concesionario",HttpStatus.NOT_FOUND, null );
        }catch (Exception e){
            return ResponseHandler.generateResponse(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR,null);
        }
    }



}
