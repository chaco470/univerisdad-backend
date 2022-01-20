package com.spring.universidad.universidadbackend.servicios.implementaciones;

import com.spring.universidad.universidadbackend.modelo.entidades.Aula;
import com.spring.universidad.universidadbackend.modelo.entidades.Pabellon;
import com.spring.universidad.universidadbackend.repositorio.PabellonRepository;
import com.spring.universidad.universidadbackend.servicios.contratos.PabellonDAO;

public class PabellonDAOImpl extends GenericDAOImpl<Pabellon, PabellonRepository> implements PabellonDAO {

    public PabellonDAOImpl(PabellonRepository repo) {
        super(repo);
    }

    @Override
    public Iterable<Aula> findPabellonByDireccion_Localidad(String localidad) {
        return repo.findPabellonByDireccion_Localidad(localidad);
    }

    @Override
    public Iterable<Aula> findPabellonByNombre(String nombre) {
        return repo.findPabellonByNombre(nombre);
    }
}
