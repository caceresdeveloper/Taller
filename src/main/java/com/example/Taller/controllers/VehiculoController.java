package com.example.Taller.controllers;

import com.example.Taller.entities.Concesionario;
import com.example.Taller.entities.Vehiculo;
import com.example.Taller.responses.ResponseHandler;
import com.example.Taller.services.ConcesionarioService;
import com.example.Taller.services.VehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("vehiculos")
public class VehiculoController {
    @Autowired
    private VehiculoService vehiculoService;

    @Autowired
    private ConcesionarioService concesionarioService;

    @GetMapping
    public ResponseEntity<Object> findAll(){
        try {
            List<Vehiculo> result = vehiculoService.findAll();
            return ResponseHandler.generateResponse("Success", HttpStatus.OK,result);
        }catch (Exception e){
            return ResponseHandler.generateResponse(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR,null);
        }
    }

    @PostMapping("/{id}")
    public ResponseEntity<Object> save(@RequestBody Vehiculo vehiculo ,@PathVariable Integer id){
        try {
            Concesionario concesionario = concesionarioService.findById(id);
            if (concesionario != null){
                Vehiculo result = vehiculoService.save(vehiculo , concesionario);
                return ResponseHandler.generateResponse("Success",HttpStatus.CREATED,vehiculo);
            }
            return ResponseHandler.generateResponse("Success concesionario",HttpStatus.NOT_FOUND,null);
        }catch (Exception e){
            return ResponseHandler.generateResponse(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR,null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Integer id){
        try {
            Vehiculo vehiculo = vehiculoService.findById(id);
            if (vehiculo != null){
                vehiculoService.delete(vehiculo);
                return ResponseHandler.generateResponse("Success",HttpStatus.ACCEPTED,vehiculo);
            }
            return ResponseHandler.generateResponse("Success Concesionario",HttpStatus.NOT_FOUND,null);
        }catch (Exception e){
            return ResponseHandler.generateResponse(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR,null);
        }
    }











}
