package com.spring.universidad.universidadbackend.servicios.contratos;

import com.spring.universidad.universidadbackend.modelo.entidades.Carrera;

public interface CarreraDAO extends GenericDAO<Carrera>{

    Iterable<Carrera>findCarrerasByNombreContains(String nombre);
    Iterable<Carrera>findCarrerasByNombreContainsIgnoreCase(String nombre);
    Iterable<Carrera>findCarrerasByCantidadAnios(Integer cantidadAnios);
    Iterable<Carrera> buscarCarrerasPorProfesorNombreYApellido(String nombre, String apellido);

}
