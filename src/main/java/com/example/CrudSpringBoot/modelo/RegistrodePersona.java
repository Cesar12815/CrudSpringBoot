package com.example.CrudSpringBoot.modelo;

import javax.persistence.*;

@Entity
@Table(name = "persona")
public class RegistrodePersona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    private String Nombre;
    private String Apellido;
    private String Correo ;
    private int Telefono;
    private String Dirección;

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String correo) {
        Correo = correo;
    }

    public int getTelefono() {
        return Telefono;
    }

    public void setTelefono(int telefono) {
        Telefono = telefono;
    }

    public String getDirección() {
        return Dirección;
    }

    public void setDirección(String dirección) {
        Dirección = dirección;
    }

    public RegistrodePersona() {
    }
}
