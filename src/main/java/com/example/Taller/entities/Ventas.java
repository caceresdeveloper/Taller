package com.example.Taller.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "ventass")
public class Ventas {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false)
    private LocalDate fecha;

    @ManyToOne
    @JoinColumn(name = "concesionario_id")
    private Concesionario ventas;

    @ManyToMany
    @JoinTable(name = "ventas_concesionarios",
            joinColumns = @JoinColumn(name = "venta_id"),
            inverseJoinColumns = @JoinColumn(name = "concesionario_id"))
    private List<Concesionario> concesionarios;

    public Ventas(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public List<Concesionario> getConcesionarios() {
        return concesionarios;
    }

    public void setConcesionarios(List<Concesionario> concesionarios) {
        this.concesionarios = concesionarios;
    }
}
