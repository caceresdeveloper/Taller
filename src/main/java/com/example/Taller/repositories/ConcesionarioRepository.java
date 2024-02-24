package com.example.Taller.repositories;

import com.example.Taller.entities.Concesionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConcesionarioRepository extends JpaRepository<Concesionario,Integer> {
    @Query("SELECT a FROM Concesionario a WHERE  a.name LIKE CONCAT('%',:name,'%')")
    public List<Concesionario> findByName(String name);

    public List<Concesionario> findByCountry(String country);
}
