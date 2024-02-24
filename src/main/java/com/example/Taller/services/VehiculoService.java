package com.example.Taller.services;

import com.example.Taller.entities.Concesionario;
import com.example.Taller.entities.Vehiculo;
import com.example.Taller.repositories.VehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehiculoService {
    @Autowired
    private VehiculoRepository vehiculoRepository;

    public List<Vehiculo> findAll(){
        return vehiculoRepository.findAll();
    }

    public Vehiculo save(Vehiculo vehiculo, Concesionario concesionario){
        vehiculo.setConcesionario(concesionario);
        return vehiculoRepository.save(vehiculo);
    }

    public Vehiculo findById(Integer id){
        Optional<Vehiculo> optional = vehiculoRepository.findById(id);
        return optional.isPresent() ? optional.get() : null;
    }

    public void delete(Vehiculo vehiculo){
        vehiculoRepository.delete(vehiculo);
    }


}
