package com.spring.universidad.universidadbackend.servicios.contratos;


import com.spring.universidad.universidadbackend.modelo.entidades.Aula;
import com.spring.universidad.universidadbackend.modelo.entidades.Pabellon;

public interface PabellonDAO extends GenericDAO<Pabellon>{

    Iterable<Pabellon>findPabellonByDireccion_Localidad(String localidad);
    Iterable<Pabellon>findPabellonByNombre(String nombre);
}
