package com.spring.universidad.universidadbackend.servicios.contratos;


import com.spring.universidad.universidadbackend.modelo.entidades.Aula;
import com.spring.universidad.universidadbackend.modelo.entidades.Pabellon;

public interface PabellonDAO extends GenericDAO<Pabellon>{

    Iterable<Aula>findPabellonByDireccion_Localidad(String localidad);
    Iterable<Aula>findPabellonByNombre(String nombre);
}
