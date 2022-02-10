package com.spring.universidad.universidadbackend.repositorio;

import com.spring.universidad.universidadbackend.modelo.entidades.Aula;
import com.spring.universidad.universidadbackend.modelo.entidades.Pabellon;
import org.springframework.data.repository.CrudRepository;

public interface PabellonRepository extends CrudRepository<Pabellon, Integer> {

    Iterable<Pabellon>findPabellonByDireccion_Localidad(String localidad);
    Iterable<Pabellon>findPabellonByNombre(String nombre);



}
