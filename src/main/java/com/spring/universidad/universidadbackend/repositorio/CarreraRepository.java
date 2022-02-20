package com.spring.universidad.universidadbackend.repositorio;

import com.spring.universidad.universidadbackend.modelo.entidades.Carrera;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface CarreraRepository extends CrudRepository<Carrera, Integer> {

    Iterable<Carrera>findCarrerasByNombreContains(String nombre);
    Iterable<Carrera>findCarrerasByNombreContainsIgnoreCase(String nombre);
    Iterable<Carrera>findCarrerasByCantidadAnios(Integer cantidadAnios);
    @Query("select c from Carrera c join fetch c.profesores p where p.nombre = ?1 and p.apellido = ?2")
    Iterable<Carrera>buscarCarrerasPorProfesorNombreYApellido(String nombre, String apellido);
}
