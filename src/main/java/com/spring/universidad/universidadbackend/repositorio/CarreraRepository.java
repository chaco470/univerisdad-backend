package com.spring.universidad.universidadbackend.repositorio;

import com.spring.universidad.universidadbackend.modelo.entidades.Carrera;
import org.springframework.data.repository.CrudRepository;


public interface CarreraRepository extends CrudRepository<Carrera, Integer> {

    Iterable<Carrera>findCarrerasByNombreContains(String nombre);
    Iterable<Carrera>findCarrerasByNombreContainsIgnoreCase(String nombre);
    Iterable<Carrera>findCarrerasByCantidadAnios(Integer cantidadAnios);
}
