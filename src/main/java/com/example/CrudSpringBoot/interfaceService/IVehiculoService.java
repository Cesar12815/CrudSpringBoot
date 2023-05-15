package com.example.CrudSpringBoot.interfaceService;

import com.example.CrudSpringBoot.modelo.RegistrodeCarro;
import com.example.CrudSpringBoot.modelo.Vehiculo;

import java.util.List;
import java.util.Optional;

public interface IVehiculoService {

    List<Vehiculo> listar();

    Optional<Vehiculo> buscarPorId(int id);

    int guardar(Vehiculo v);

    void eliminar(int id);

    List<Vehiculo> listarPorTipo(String tipo);

    List<Vehiculo> listarParqueados(boolean parqueado);

    boolean actualizarParqueo(int id, boolean parqueado);

    Optional<Vehiculo> obtenerVehiculoPorId(int id);

    List<Vehiculo> obtenerVehiculos();

    void eliminarVehiculoPorId(int id);

    Optional<RegistrodeCarro> buscarRegistroPorId(Long id);

    Optional<Vehiculo> buscarPorPlaca(String placa);

    void registrarCarro(RegistrodeCarro nuevoRegistro);
}