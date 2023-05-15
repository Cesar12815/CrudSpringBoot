package com.example.CrudSpringBoot.modelo;
import java.time.LocalTime;
import javax.persistence.*;
@Entity
@Table(name = "Recibo")
public class ReciboCarro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @Column(nullable = false)
    private String placa;


    @Column(nullable = false)
    private LocalTime horaEntrada;

    @Column
    private LocalTime horaSalida;

    protected ReciboCarro() {
    }

}
