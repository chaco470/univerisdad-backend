package com.spring.universidad.universidadbackend.servicios.implementaciones;

import com.spring.universidad.universidadbackend.modelo.entidades.Persona;
import com.spring.universidad.universidadbackend.repositorio.AlumnoRepository;
import com.spring.universidad.universidadbackend.servicios.contratos.AlumnoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class AlumnoDAOImpl implements AlumnoDAO {

    @Autowired
    @Qualifier("repositorioAlumnos")
    private AlumnoRepository repo;

    @Override
    @Transactional(readOnly = true)
    public Optional<Persona> findById(Integer id) {
        return repo.findById(id);
    }

    @Override
    @Transactional
    public Persona save(Persona persona) {
        return repo.save(persona);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Persona> findAll() {
        return repo.findAll();
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        repo.deleteById(id);
    }
}
