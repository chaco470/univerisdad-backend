package com.spring.universidad.universidadbackend.controlador;

import com.spring.universidad.universidadbackend.exception.BadRequestException;
import com.spring.universidad.universidadbackend.modelo.entidades.Carrera;
import com.spring.universidad.universidadbackend.servicios.contratos.CarreraDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/carreras")
public class CarreraController extends GenericController<Carrera, CarreraDAO>{


    @Autowired
    public CarreraController(CarreraDAO service) {
        super(service);
        nombreEntidad = "Carrera";
    }
/*
    @PutMapping("/{id}")
    public Carrera actualizarCarrera(@PathVariable Integer id, @RequestBody Carrera carrera){
        Optional<Carrera> oCarrera = service.findById(id);
        if (oCarrera.isEmpty()){
            throw new BadRequestException(String.format("la carrera con id %d no existe", id));
        }
        Carrera carreraUpdate = oCarrera.get();
        carreraUpdate.setCantidadAnios(carrera.getCantidadAnios());
        carreraUpdate.setCantidadMaterias(carrera.getCantidadMaterias());
        carreraUpdate.setNombre(carrera.getNombre());
        return service.save(carreraUpdate);
    }

 */
    //nombreCarrera?nombreCarrera=ingenieria
    @GetMapping("/nombreCarrera")
    public ResponseEntity<?> findCarrerasByNombreContainsIgnoreCase(@RequestParam String nombreCarrera){
        Map<String, Object> message = new HashMap<>();
        List<Carrera> listCarreras = (List<Carrera>) service.findCarrerasByNombreContainsIgnoreCase(nombreCarrera);
        if (listCarreras.isEmpty()) {
            //throw new BadRequestException(String.format("No existen carreras que contengan el nombre %s", nombreCarrera));
            message.put("succes", Boolean.FALSE);
            message.put("message",String.format("La carrera con nombre: %s no existen", nombreCarrera));
            return ResponseEntity.badRequest().body(message);
        }
        message.put("datos", listCarreras);
        message.put("succes", Boolean.TRUE);
        return ResponseEntity.ok(message);
    }

    @GetMapping("/nombre-apellido")
    public ResponseEntity<?> carrerarsPorNombreYApellidoProfesor(@RequestParam String nombre, @RequestParam String apellido){
        Map<String, Object> message = new HashMap<>();
        List<Carrera> listCarreras = (List<Carrera>) service.buscarCarrerasPorProfesorNombreYApellido(nombre, apellido);
        if(listCarreras.isEmpty()){
            message.put("succes", Boolean.FALSE);
            message.put("message",String.format("No hay ninguna carrera asiganada al profesor con nombre: %s ni apellido: %s", nombre, apellido));
            return ResponseEntity.badRequest().body(message);
        }
        message.put("datos", listCarreras);
        message.put("succes", Boolean.TRUE);
        return ResponseEntity.ok(message);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarCarrera(@PathVariable Integer id, @RequestBody Carrera carrera, BindingResult result){
        Map<String, Object> message = new HashMap<>();
        Optional<Carrera> oCarrera = service.findById(id);
        if(!oCarrera.isPresent()){
            message.put("succes", Boolean.FALSE);
            message.put("message",String.format("La carrera con id %d no existen", id));
            return ResponseEntity.badRequest().body(message);
        }
        if (result.hasErrors()){
            result.getFieldErrors()
                    .forEach(fieldError -> message.put(fieldError.getField(), fieldError.getDefaultMessage()));
            return ResponseEntity.badRequest().body(message);
        }
        Carrera carreraUpdate = oCarrera.get();
        carreraUpdate.setCantidadAnios(carrera.getCantidadAnios());
        carreraUpdate.setCantidadMaterias(carrera.getCantidadMaterias());
        carreraUpdate.setNombre(carrera.getNombre());
        message.put("datos", service.save(carreraUpdate));
        message.put("succes", Boolean.TRUE);
        return ResponseEntity.ok(message);
    }
}
