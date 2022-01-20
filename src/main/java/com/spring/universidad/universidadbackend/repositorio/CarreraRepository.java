package com.spring.universidad.universidadbackend.repositorio;

import com.spring.universidad.universidadbackend.modelo.entidades.Carrera;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface CarreraRepository extends CrudRepository<Carrera, Integer> {

    Iterable<Carrera>findCarrerasByNombreContains(String nombre);
    Iterable<Carrera>findCarrerasByNombreContainsIgnoreCase(String nombre);
    Iterable<Carrera>findCarrerasByCantidadAnios(Integer cantidadAnios);
    //@Query("select c form Carrera c join (select p from Profesor where p.nombre = ?1 and p.apellido = ?2) p")
    //@Query("select c form Carrera c where c (select p from Profesor p where p.nombre= ?1 and p.apellido = ?2) p ")
    //Iterable<Carrera> buscarCarrerasPorProfesorNombreYApellido(String nombre, String apellido);
}
