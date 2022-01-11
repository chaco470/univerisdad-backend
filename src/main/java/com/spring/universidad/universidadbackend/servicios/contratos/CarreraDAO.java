package com.spring.universidad.universidadbackend.servicios.contratos;

import com.spring.universidad.universidadbackend.modelo.entidades.Carrera;

import java.util.Optional;

public interface CarreraDAO extends GenericDAO<Carrera>{

    Iterable<Carrera>findCarrerasByNombreContains(String nombre);
    Iterable<Carrera>findCarrerasByNombreContainsIgnoreCase(String nombre);
    Iterable<Carrera>findCarrerasByCantidadAnios(Integer cantidadAnios);

}
