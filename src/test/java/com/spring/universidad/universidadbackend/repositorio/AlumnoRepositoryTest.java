package com.spring.universidad.universidadbackend.repositorio;

import com.spring.universidad.universidadbackend.modelo.entidades.Alumno;
import com.spring.universidad.universidadbackend.modelo.entidades.Carrera;
import com.spring.universidad.universidadbackend.modelo.entidades.Persona;
import datos.DatosDummy;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class AlumnoRepositoryTest {

    @Autowired
    @Qualifier("repositorioAlumnos")
    PersonaRepository alumnoRepository;
    @Autowired
    CarreraRepository carreraRepository;

    @Test
    void buscarAlumnoPorNombreCarrera() {

        Iterable<Persona> personas = alumnoRepository.saveAll(Arrays.asList(DatosDummy.alumno01(), DatosDummy.alumno02()));
        Carrera save = carreraRepository.save(DatosDummy.carrera1());
        personas.forEach(alumno -> ((Alumno)alumno).setCarrera(save));
        alumnoRepository.saveAll(personas);
        List<Persona> expected = (List<Persona>) ((AlumnoRepository)alumnoRepository).buscarAlumnoPorNombreCarrera(save.getNombre());
        assertThat(expected.size() == 2).isTrue();

    }
}