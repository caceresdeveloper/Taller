package com.example.Taller.services;

import com.example.Taller.entities.Concesionario;
import com.example.Taller.entities.Vehiculo;
import com.example.Taller.entities.Ventas;
import com.example.Taller.repositories.ConcesionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConcesionarioService {
    @Autowired
    ConcesionarioRepository concesionarioRepository;

    public List<Concesionario> findAll(){
        return concesionarioRepository.findAll();
    }

    public Concesionario findById(Integer id){
        Optional<Concesionario> optional = concesionarioRepository.findById(id);
        return optional.isPresent() ? optional.get() : null;
    }

    public Concesionario save(Concesionario concesionario){
        return concesionarioRepository.save(concesionario);
    }

    public List<Concesionario> findByCountry(String country){
        return concesionarioRepository.findByCountry(country);
    }

    public List<Concesionario> findByName(String name){
        return concesionarioRepository.findByName(name);
    }

    public List<Vehiculo> getVehiculos(Concesionario concesionario){
        return concesionario.getVehiculos();
    }

    public List<Ventas> getVentass(Concesionario concesionario){
        return concesionario.getVentass();
    }

    public void delete(Concesionario concesionario){
        concesionarioRepository.delete(concesionario);
    }
}
