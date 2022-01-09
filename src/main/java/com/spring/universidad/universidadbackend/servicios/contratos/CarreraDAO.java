package com.spring.universidad.universidadbackend.servicios.contratos;

import com.spring.universidad.universidadbackend.modelo.entidades.Carrera;

import java.util.Optional;

public interface CarreraDAO {


    Optional<Carrera> findById(Integer id);
    Carrera save(Carrera carrera);
    Iterable<Carrera> findAll();
    void deleteById(Integer id);

}
