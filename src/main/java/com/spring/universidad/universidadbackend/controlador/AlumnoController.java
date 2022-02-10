package com.spring.universidad.universidadbackend.controlador;

import com.spring.universidad.universidadbackend.exception.BadRequestException;
import com.spring.universidad.universidadbackend.modelo.entidades.Alumno;
import com.spring.universidad.universidadbackend.modelo.entidades.Carrera;
import com.spring.universidad.universidadbackend.modelo.entidades.Persona;
import com.spring.universidad.universidadbackend.servicios.contratos.CarreraDAO;
import com.spring.universidad.universidadbackend.servicios.contratos.PersonaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/alumnos")
public class AlumnoController extends PersonaController{

    private final CarreraDAO carreraDAO;

    @Autowired
    public AlumnoController(@Qualifier("alumnoDAOImpl") PersonaDAO alumnoDAO, CarreraDAO carreraDAO) {
        super(alumnoDAO);
        nombreEntidad = "Alumno";
        this.carreraDAO = carreraDAO;
    }

    @PutMapping("/{id}")
    public Persona actualizarPersona(@PathVariable Integer id,@RequestBody Persona alumno){
        Persona alumnoUpdate;
        Optional<Persona> oAlumno = service.findById(id);
        if (oAlumno.isEmpty()){throw new BadRequestException(String.format("el alumno con id %d no existe", id));}
        alumnoUpdate = oAlumno.get();
        alumnoUpdate.setNombre(alumno.getNombre());
        alumnoUpdate.setApellido(alumno.getApellido());
        alumnoUpdate.setDireccion(alumno.getDireccion());
        return service.save(alumnoUpdate);
    }

    @PutMapping("/{idAlumno}/carrera/{idCarrera}")
    public Persona agregarCarreraAlumno(@PathVariable Integer idAlumno, @PathVariable Integer idCarrera){
        Optional<Persona> oAlumno = service.findById(idAlumno);
        if (oAlumno.isEmpty()){ throw new BadRequestException(String.format("el alumno con id %d no existe", idAlumno)); }
        Optional<Carrera> oCarrera = carreraDAO.findById(idCarrera);
        if (oCarrera.isEmpty()){ throw new BadRequestException(String.format("la carrera con id %d no existe", idCarrera)); }
        Persona alumnoUpdate = oAlumno.get();
        ((Alumno)alumnoUpdate).setCarrera(oCarrera.get());
        return service.save(alumnoUpdate);
    }
}
