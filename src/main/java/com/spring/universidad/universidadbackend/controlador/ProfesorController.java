package com.spring.universidad.universidadbackend.controlador;

import com.spring.universidad.universidadbackend.exception.BadRequestException;
import com.spring.universidad.universidadbackend.modelo.entidades.Carrera;
import com.spring.universidad.universidadbackend.modelo.entidades.Persona;
import com.spring.universidad.universidadbackend.modelo.entidades.Profesor;
import com.spring.universidad.universidadbackend.servicios.contratos.CarreraDAO;
import com.spring.universidad.universidadbackend.servicios.contratos.PersonaDAO;
import com.spring.universidad.universidadbackend.servicios.contratos.ProfesorDAO;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public class ProfesorController extends PersonaController{

    private final CarreraDAO carreraDAO;

    public ProfesorController(@Qualifier("profesorDAOImpl") PersonaDAO profesorDao, CarreraDAO carreraDAO) {
        super(profesorDao);
        this.carreraDAO = carreraDAO;
        nombreEntidad = "Profesor";
    }

    public List<Persona> buscarProfesoresPorCarrera(String nombreCarrera){
        List<Persona> personas = (List<Persona>) ((ProfesorDAO) service).buscarProfesoresPorCarrera(nombreCarrera);
        if (personas.isEmpty()) throw new BadRequestException(String.format("la carrera %s no posee ningun profesor aun", nombreCarrera));
        return personas;
    }

    public Profesor agergarCarreraAProfesor(Integer idProfesor, Integer idCarrera){
        Optional<Persona> oProfesor = service.findById(idProfesor);
        Optional<Carrera> oCarrera = carreraDAO.findById(idCarrera);
        if (!oProfesor.isPresent() || !oCarrera.isPresent()) throw new BadRequestException(String.format("El profesor con id %d o la carrera con %d no existen", idProfesor, idCarrera));
        Profesor profesor = (Profesor) oProfesor.get();
        Set<Carrera> carrerasProfesor = profesor.getCarreras();
        carrerasProfesor.add(oCarrera.get());
        profesor.setCarreras(carrerasProfesor);
        return (Profesor) service.save(profesor);
    }


}
