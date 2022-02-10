package com.spring.universidad.universidadbackend.repositorio;

import com.spring.universidad.universidadbackend.modelo.entidades.Persona;
import com.spring.universidad.universidadbackend.modelo.entidades.numeradores.TipoEmpleado;
import datos.DatosDummy;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class EmpleadoRepositoryTest {

    @Autowired
    @Qualifier("repositorioEmpleados")
    PersonaRepository empleadoRepository;

    @Test
    void findEmpleadoByTipoEmpleado() {
        empleadoRepository.save(DatosDummy.empleado01());
        Iterable<Persona> expected = ((EmpleadoRepository)empleadoRepository).findEmpleadoByTipoEmpleado(TipoEmpleado.ADMINISTRATIVO);
        assertThat(((List <Persona>)expected).size() == 1).isTrue();
    }
}