package com.spring.universidad.universidadbackend.repositorio;

import com.spring.universidad.universidadbackend.modelo.entidades.Persona;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository("repositorioAlumnos")
public interface AlumnoRepository extends PersonaRepository{

    @Query("select a from Alumno a where a.carrera.nombre = ?1")
    //@Query("select a from Alumno a join fetch a.carrera c where c.nombre = ?1") //en caso de error al inicializar proxy implementar esta query
    Iterable<Persona> buscarAlumnoPorNombreCarrera(String nombreCarrera);

}
