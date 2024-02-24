package com.example.Taller.services;

import com.example.Taller.entities.Concesionario;
import com.example.Taller.entities.Ventas;
import com.example.Taller.repositories.VentasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VentasService {
    @Autowired
    private VentasRepository ventasRepository;

    public List<Ventas> findAll(){
        return ventasRepository.findAll();
    }

    public Ventas save(Ventas ventas, List<Concesionario> concesionario){
        ventas.setConcesionarios(concesionario);
        return ventasRepository.save(ventas);
    }

    public Ventas findById(Integer id){
        Optional<Ventas> optional = ventasRepository.findById(id);
        return optional.isPresent() ? optional.get() :null;
    }

    public void delete(Ventas ventas){
        ventasRepository.delete(ventas);
    }
}
