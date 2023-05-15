package com.example.CrudSpringBoot.service;


import com.example.CrudSpringBoot.interfaceService.IVehiculoService;
import com.example.CrudSpringBoot.interfaces.IRegistrodeCarro;
import com.example.CrudSpringBoot.interfaces.IVehiculo;
import com.example.CrudSpringBoot.modelo.RegistrodeCarro;
import com.example.CrudSpringBoot.modelo.Vehiculo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.stream.StreamSupport;

import java.util.List;
import java.util.Optional;

@Service
public class VehiculoService implements IVehiculoService {

    @Autowired
    private IVehiculo data;

    @Autowired
    private IRegistrodeCarro registroRepository;

    @Override
    public void registrarCarro(RegistrodeCarro nuevoRegistro) {
        RegistrodeCarro registroGuardado = registroRepository.save(nuevoRegistro);
        if (registroGuardado == null) {
            throw new RuntimeException("No se pudo guardar el registro del carro");
        }
    }

    @Override
    public Optional<Vehiculo> buscarPorPlaca(String placa) {
        return StreamSupport.stream(data.findAll().spliterator(), false)
                .filter(v -> v.getPlaca().equals(placa))
                .findFirst();
    }

    @Override
    public List<Vehiculo> listar() {
        return (List<Vehiculo>) data.findAll();
    }

    @Override
    public Optional<Vehiculo> buscarPorId(int id) {
        return data.findById((long) id);
    }

    @Override
    public int guardar(Vehiculo v) {
        Vehiculo vehiculo = data.save(v);
        return vehiculo != null ? 1 : 0;
    }

    @Override
    public void eliminar(int id) {
        data.deleteById((long) id);
    }

    @Override
    public List<Vehiculo> listarPorTipo(String tipo) {
        return data.findByTipo(tipo);
    }

    @Override
    public List<Vehiculo> listarParqueados(boolean parqueado) {
        return data.findByParqueado(parqueado);
    }

    @Override
    public boolean actualizarParqueo(int id, boolean parqueado) {
        Optional<Vehiculo> vehiculo = data.findById((long) id);
        if (vehiculo.isPresent()) {
            vehiculo.get().setParqueado(parqueado);
            data.save(vehiculo.get());
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Optional<Vehiculo> obtenerVehiculoPorId(int id) {
        return data.findById((long) id);
    }

    @Override
    public List<Vehiculo> obtenerVehiculos() {
        return (List<Vehiculo>) data.findAll();
    }

    @Override
    public void eliminarVehiculoPorId(int id) {
        data.deleteById((long) id);
    }

    @Override
    public Optional<RegistrodeCarro> buscarRegistroPorId(Long id) {
        return Optional.empty();
    }
}