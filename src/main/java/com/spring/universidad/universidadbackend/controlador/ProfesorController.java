package com.spring.universidad.universidadbackend.controlador;

import com.spring.universidad.universidadbackend.exception.BadRequestException;
import com.spring.universidad.universidadbackend.modelo.entidades.Carrera;
import com.spring.universidad.universidadbackend.modelo.entidades.Persona;
import com.spring.universidad.universidadbackend.modelo.entidades.Profesor;
import com.spring.universidad.universidadbackend.servicios.contratos.CarreraDAO;
import com.spring.universidad.universidadbackend.servicios.contratos.PersonaDAO;
import com.spring.universidad.universidadbackend.servicios.contratos.ProfesorDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/profesores")
public class ProfesorController extends PersonaController{

    private final CarreraDAO carreraDAO;

    @Autowired
    public ProfesorController(@Qualifier("profesorDAOImpl") PersonaDAO profesorDao, CarreraDAO carreraDAO) {
        super(profesorDao);
        this.carreraDAO = carreraDAO;
        nombreEntidad = "Profesor";
    }

    @GetMapping("/nombreCarrera")
    public ResponseEntity<?> buscarProfesoresPorCarrera(@RequestParam String nombreCarrera){
        Map<String, Object> message = new HashMap<>();
        List<Persona> profesores = (List<Persona>) ((ProfesorDAO) service).buscarProfesoresPorCarrera(nombreCarrera);
        if (profesores.isEmpty()) {
            //throw new BadRequestException(String.format("la carrera %s no posee ningun profesor aun", nombreCarrera));
            message.put("succes", Boolean.FALSE);
            message.put("message",String.format("la carrera %s no posee ningun profesor aun", nombreCarrera));
            return ResponseEntity.badRequest().body(message);
        }
        message.put("succes", Boolean.TRUE);
        message.put("datos", profesores);
        return ResponseEntity.ok(message);
    }

    @PutMapping("/{idProfesor}/carrera/{idCarrera}")
    public ResponseEntity<?> agergarCarreraAProfesor(@PathVariable Integer idProfesor, @PathVariable Integer idCarrera){
        Map<String, Object> message = new HashMap<>();
        Optional<Persona> oProfesor = service.findById(idProfesor);
        Optional<Carrera> oCarrera = carreraDAO.findById(idCarrera);
        if (!oProfesor.isPresent() || !oCarrera.isPresent()) {
            //throw new BadRequestException(String.format("El profesor con id %d o la carrera con %d no existen", idProfesor, idCarrera));
            message.put("succes", Boolean.FALSE);
            message.put("message",String.format("El profesor con id %d o la carrera con id %d no existen", idProfesor, idCarrera));
            return ResponseEntity.badRequest().body(message);
        }
        Profesor profesor = (Profesor) oProfesor.get();
        Set<Carrera> carrerasProfesor = profesor.getCarreras();
        carrerasProfesor.add(oCarrera.get());
        profesor.setCarreras(carrerasProfesor);
        message.put("succes", Boolean.TRUE);
        message.put("datos", service.save(profesor));
        return ResponseEntity.ok(message);
    }

}
