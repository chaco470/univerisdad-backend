package com.spring.universidad.universidadbackend.servicios.contratos;

import com.spring.universidad.universidadbackend.modelo.entidades.Persona;

public interface ProfesorDAO extends PersonaDAO {


    Iterable<Persona> buscarProfesoresPorCarrera(String carrera);

}
