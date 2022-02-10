package com.spring.universidad.universidadbackend.repositorio;

import com.spring.universidad.universidadbackend.modelo.entidades.Empleado;
import com.spring.universidad.universidadbackend.modelo.entidades.Persona;
import com.spring.universidad.universidadbackend.modelo.entidades.Profesor;
import datos.DatosDummy;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class PersonaRepositoryTest {

    @Autowired
    @Qualifier("repositorioAlumnos")
    PersonaRepository alumnoRepository;
    @Autowired
    @Qualifier("repositorioEmpleados")
    PersonaRepository empleadoRepository;

    @Autowired
    @Qualifier("repositorioProfesores")
    ProfesorRepository profesorRepository;

    @BeforeEach
    void setUp() {
        empleadoRepository.save(DatosDummy.empleado01());
        empleadoRepository.save(DatosDummy.empleado02());
        profesorRepository.save(DatosDummy.profesor01());
        alumnoRepository.saveAll(Arrays.asList(DatosDummy.alumno01(), DatosDummy.alumno02()));

    }

    @BeforeAll
    static void beforeAll() {
    }

    @Test
    void buscarPorNombreYApellido() {
        Optional<Persona> expected = empleadoRepository.buscarPorNombreYApellido(DatosDummy.empleado01().getNombre(), DatosDummy.empleado01().getApellido());
        assertThat(expected.get()).isInstanceOf(Empleado.class);
    }

    @Test
    void buscarPorDni() {
        Optional<Persona> expected = profesorRepository.buscarPorDni(DatosDummy.profesor01().getDni());
        assertThat(expected.get()).isInstanceOf(Profesor.class);

    }

    @Test
    void buscarPorApellido() {
        Iterable<Persona> expected = alumnoRepository.buscarPorApellido(DatosDummy.alumno01().getApellido());
        assertThat(((List<Persona>)expected).size() == 2).isTrue();
    }
}