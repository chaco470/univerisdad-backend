package com.spring.universidad.universidadbackend.repositorio;

import com.spring.universidad.universidadbackend.modelo.entidades.Aula;
import com.spring.universidad.universidadbackend.modelo.entidades.Pabellon;
import com.spring.universidad.universidadbackend.modelo.entidades.numeradores.TipoPizzarron;
import org.springframework.data.repository.CrudRepository;

public interface PabellonRepository extends CrudRepository<Pabellon, Integer> {

    Iterable<Aula>findPabellonByDireccion_Localidad(String localidad);
    Iterable<Aula>findPabellonByNombre(String nombre);



}
