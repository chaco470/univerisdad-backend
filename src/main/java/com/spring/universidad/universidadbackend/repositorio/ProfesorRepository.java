package com.spring.universidad.universidadbackend.repositorio;

import com.spring.universidad.universidadbackend.modelo.entidades.Persona;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository("repositorioProfesores")
public interface ProfesorRepository extends PersonaRepository{

    //@Query("select p from Profesor p join fetch p.carreras c where c.nombre like %?1%")
    @Query("select p from Profesor p join fetch p.carreras c where c.nombre like %?1%")
    Iterable<Persona> buscarProfesoresPorCarrera(String carrera);

}
