package com.spring.universidad.universidadbackend.servicios.implementaciones;

import com.spring.universidad.universidadbackend.modelo.entidades.Persona;
import com.spring.universidad.universidadbackend.repositorio.AlumnoRepository;
import com.spring.universidad.universidadbackend.repositorio.PersonaRepository;
import com.spring.universidad.universidadbackend.servicios.contratos.AlumnoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;



@Service
public class AlumnoDAOImpl extends PersonaDAOImpl implements AlumnoDAO {

    @Autowired
    public AlumnoDAOImpl(@Qualifier("repositorioAlumnos")PersonaRepository repo) {
        super(repo);
    }


    @Override
    public Iterable<Persona> buscarAlumnoPorNombreCarrera(String nombreCarrera) {
        return ((AlumnoRepository) repo).buscarAlumnoPorNombreCarrera(nombreCarrera);
    }
}
