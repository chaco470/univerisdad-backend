package com.spring.universidad.universidadbackend.servicios.implementaciones;

import com.spring.universidad.universidadbackend.modelo.entidades.Persona;
import com.spring.universidad.universidadbackend.modelo.entidades.numeradores.TipoEmpleado;
import com.spring.universidad.universidadbackend.repositorio.EmpleadoRepository;
import com.spring.universidad.universidadbackend.repositorio.PersonaRepository;
import com.spring.universidad.universidadbackend.servicios.contratos.EmpleadoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmpleadoDAOImpl extends PersonaDAOImpl implements EmpleadoDAO {

    @Autowired
    public EmpleadoDAOImpl(@Qualifier("repositorioEmpleados")PersonaRepository repo) {super(repo);}

    @Override
    @Transactional(readOnly = true)
    public Iterable<Persona> findEmpleadoByTipoEmpleado(TipoEmpleado tipoEmpleado) {
        return ((EmpleadoRepository) repo).findEmpleadoByTipoEmpleado(tipoEmpleado);
    }
}
