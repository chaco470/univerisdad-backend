package com.spring.universidad.universidadbackend.servicios.contratos;


import com.spring.universidad.universidadbackend.modelo.entidades.Persona;

public interface AlumnoDAO extends PersonaDAO{

    Iterable<Persona> buscarAlumnoPorNombreCarrera(String nombreCarrera);

}
