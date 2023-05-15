package com.example.CrudSpringBoot.interfaces;

import com.example.CrudSpringBoot.modelo.RegistrodePersona;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface IRegistrodepersona extends CrudRepository<RegistrodePersona, Long> {
        // métodos personalizados para acceder a los datos de RegistrodeCarro, si es necesario
}
