package com.example.CrudSpringBoot.modelo;

import javax.persistence.*;

@Entity
@Table(name = "vehiculo")
public class Vehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String placa;
    private String tipo;
    private String marca;
    private boolean parqueado;

    public Vehiculo() {
    }

    public Vehiculo(String placa, String tipo, String marca, boolean parqueado) {
        this.placa = placa;
        this.tipo = tipo;
        this.marca = marca;
        this.parqueado = parqueado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public boolean isParqueado() {
        return parqueado;
    }

    public void setParqueado(boolean parqueado) {
        this.parqueado = parqueado;
    }
}
