package com.spring.universidad.universidadbackend.servicios.contratos;

import com.spring.universidad.universidadbackend.modelo.entidades.Persona;

import java.util.Optional;

public interface PersonaDAO {
    Optional<Persona> findById(Integer id);
    Persona save(Persona persona);
    Iterable<Persona> findAll();
    void deleteById(Integer id);
}
