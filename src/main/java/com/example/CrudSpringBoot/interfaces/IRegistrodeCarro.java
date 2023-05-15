package com.example.CrudSpringBoot.interfaces;

import com.example.CrudSpringBoot.modelo.RegistrodeCarro;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRegistrodeCarro extends CrudRepository<RegistrodeCarro, Long> {
    // métodos personalizados para acceder a los datos de RegistrodeCarro, si es necesario
}
