package com.spring.universidad.universidadbackend.controlador;

import com.spring.universidad.universidadbackend.exception.BadRequestException;
import com.spring.universidad.universidadbackend.modelo.entidades.Alumno;
import com.spring.universidad.universidadbackend.modelo.entidades.Carrera;
import com.spring.universidad.universidadbackend.modelo.entidades.Persona;
import com.spring.universidad.universidadbackend.servicios.contratos.CarreraDAO;
import com.spring.universidad.universidadbackend.servicios.contratos.PersonaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
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
    public ResponseEntity<?> actualizarAlumno(@PathVariable Integer id, @RequestBody Persona alumno, BindingResult result){
        Map<String, Object> message = new HashMap<>();
        Persona alumnoUpdate;
        Optional<Persona> oAlumno = service.findById(id);
        if (result.hasErrors()){
            result.getFieldErrors()
                    .forEach(fieldError -> message.put(fieldError.getField(), fieldError.getDefaultMessage()));
            return ResponseEntity.badRequest().body(message);
        }
        alumnoUpdate = oAlumno.get();
        alumnoUpdate.setNombre(alumno.getNombre());
        alumnoUpdate.setApellido(alumno.getApellido());
        alumnoUpdate.setDireccion(alumno.getDireccion());
        message.put("succes", Boolean.TRUE);
        message.put("datos", alumnoUpdate);
        return ResponseEntity.ok(message);
    }

    @PutMapping("/{idAlumno}/carrera/{idCarrera}")
    public ResponseEntity<?> agregarCarreraAlumno(@PathVariable Integer idAlumno, @PathVariable Integer idCarrera){
        Map<String, Object> message = new HashMap<>();
        Optional<Persona> oAlumno = service.findById(idAlumno);
        Optional<Carrera> oCarrera = carreraDAO.findById(idCarrera);
        if (oAlumno.isPresent() || !oCarrera.isPresent()){
            //throw new BadRequestException(String.format("el alumno con id %d no existe", idAlumno));
            message.put("succes", Boolean.FALSE);
            message.put("message",String.format("el alumno con id: %d o la carrera con id: %d no existe", idAlumno, idCarrera));
            return ResponseEntity.badRequest().body(message);
        }
        Persona alumnoUpdate = oAlumno.get();
        ((Alumno)alumnoUpdate).setCarrera(oCarrera.get());
        message.put("succes", Boolean.TRUE);
        message.put("datos", alumnoUpdate);
        return ResponseEntity.ok(message);
    }
}
