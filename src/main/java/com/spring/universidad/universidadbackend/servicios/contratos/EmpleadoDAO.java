package com.spring.universidad.universidadbackend.servicios.contratos;

import com.spring.universidad.universidadbackend.modelo.entidades.Persona;
import com.spring.universidad.universidadbackend.modelo.entidades.numeradores.TipoEmpleado;

public interface EmpleadoDAO extends PersonaDAO{

    Iterable<Persona> findEmpleadoByTipoEmpleado(TipoEmpleado tipoEmpleado);
}
