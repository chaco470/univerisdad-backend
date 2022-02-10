package com.spring.universidad.universidadbackend.servicios.implementaciones;

import com.spring.universidad.universidadbackend.repositorio.AlumnoRepository;
import com.spring.universidad.universidadbackend.servicios.contratos.PersonaDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class PersonaDAOImplTest {

    PersonaDAO personaDAO;
    @Mock
    AlumnoRepository alumnoRepository;

    @BeforeEach
    void setUp() {
        personaDAO = new PersonaDAOImpl(alumnoRepository);
    }

    @Test
    void buscarPorNombreYApellido() {
        personaDAO.buscarPorNombreYApellido(anyString(),anyString());
        verify(alumnoRepository).buscarPorNombreYApellido(anyString(),anyString());
    }

    @Test
    void buscarPorDni() {
        personaDAO.buscarPorDni(anyString());
        verify(alumnoRepository).buscarPorDni(anyString());
    }

    @Test
    void buscarPorApellido() {
        personaDAO.buscarPorApellido(anyString());
        verify(alumnoRepository).buscarPorApellido(anyString());
    }
}