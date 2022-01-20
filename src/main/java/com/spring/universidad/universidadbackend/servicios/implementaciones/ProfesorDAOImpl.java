package com.spring.universidad.universidadbackend.servicios.implementaciones;

import com.spring.universidad.universidadbackend.modelo.entidades.Persona;
import com.spring.universidad.universidadbackend.repositorio.PersonaRepository;
import com.spring.universidad.universidadbackend.repositorio.ProfesorRepository;
import com.spring.universidad.universidadbackend.servicios.contratos.ProfesorDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProfesorDAOImpl extends PersonaDAOImpl implements ProfesorDAO {

    @Autowired
    public ProfesorDAOImpl(@Qualifier("repositorioProfesores")PersonaRepository repo) {super(repo);}

    @Override
    @Transactional(readOnly = true)
    public Iterable<Persona> buscarProfesoresPorCarrera(String carrera) {
        return ((ProfesorRepository) repo).buscarProfesoresPorCarrera(carrera);
    }
}
