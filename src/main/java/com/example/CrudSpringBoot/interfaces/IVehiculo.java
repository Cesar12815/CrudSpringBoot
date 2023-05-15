package com.example.CrudSpringBoot.interfaces;

import com.example.CrudSpringBoot.modelo.Vehiculo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IVehiculo extends CrudRepository<Vehiculo, Long> {
    List<Vehiculo> findByParqueado(boolean parqueado);
    List<Vehiculo> findByTipo(String tipo);
}