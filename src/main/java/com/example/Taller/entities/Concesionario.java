package com.example.Taller.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "concesionarios")
public class Concesionario  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false,length = 40)
    private String name;

    @Column(nullable = false,length = 40,name = "direccion")
    private String direccion;

    @Column(nullable = false,length = 40)
    private String country;

    @Column(nullable = false,length = 50)
    private String provincia;

    @Column(nullable = false,length = 200)
    private String email;

    @Column(nullable = false, name = "Numero-de-empleados")
    private Integer numeroEmpleados;

    @OneToMany(mappedBy = "concesionario")
    private List<Vehiculo> vehiculos;

    @OneToMany(mappedBy = "ventas")
    private List<Ventas> ventass;


    public Concesionario(){
        vehiculos = new ArrayList<>();
        ventass = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getNumeroEmpleados() {
        return numeroEmpleados;
    }

    public void setNumeroEmpleados(Integer numeroEmpleados) {
        this.numeroEmpleados = numeroEmpleados;
    }

    public List<Vehiculo> getVehiculos(){
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos){
        this.vehiculos = vehiculos;
    }

    public List<Ventas> getVentass() {
        return ventass;
    }

    public void setVentass(List<Ventas> ventass) {
        this.ventass = ventass;
    }
}
