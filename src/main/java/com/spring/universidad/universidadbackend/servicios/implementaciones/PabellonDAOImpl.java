package com.spring.universidad.universidadbackend.servicios.implementaciones;

import com.spring.universidad.universidadbackend.modelo.entidades.Pabellon;
import com.spring.universidad.universidadbackend.repositorio.PabellonRepository;
import com.spring.universidad.universidadbackend.servicios.contratos.PabellonDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PabellonDAOImpl extends GenericDAOImpl<Pabellon, PabellonRepository> implements PabellonDAO {

    @Autowired
    public PabellonDAOImpl(PabellonRepository repo) {
        super(repo);
    }

    @Override
    public Iterable<Pabellon> findPabellonByDireccion_Localidad(String localidad) {
        return repo.findPabellonByDireccion_Localidad(localidad);
    }

    @Override
    public Iterable<Pabellon> findPabellonByNombre(String nombre) {
        return repo.findPabellonByNombre(nombre);
    }
}
