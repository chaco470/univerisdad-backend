package com.spring.universidad.universidadbackend.controlador;

import com.spring.universidad.universidadbackend.exception.BadRequestException;
import com.spring.universidad.universidadbackend.modelo.entidades.Persona;
import com.spring.universidad.universidadbackend.servicios.contratos.PersonaDAO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class PersonaController extends GenericController<Persona, PersonaDAO>{


    public PersonaController(PersonaDAO service) {
        super(service);
    }

    @GetMapping("/nombre-apellido")
    public ResponseEntity<?> buscarPorNombreYApellido(@RequestParam String nombre, @RequestParam String apellido){
        Map<String, Object> message = new HashMap<>();
        Optional<Persona> oPersona = service.buscarPorNombreYApellido(nombre, apellido);
        if(oPersona.isEmpty()){
            //throw new BadRequestException(String.format("la persona con el nombre %s ni apellido %s no existe", nombre, apellido));
            message.put("succes", Boolean.FALSE);
            message.put("message", String.format("No existe la persona con nombre %s ni apellido %s", nombre, apellido));
            return ResponseEntity.badRequest().body(message);
        }
        message.put("succes", Boolean.TRUE);
        message.put("datos", oPersona.get());
        return ResponseEntity.ok(message);
    }
    @GetMapping("/apellido")
    public ResponseEntity<?> buscarPersonaPorApellido(@RequestParam String apellido){
        Map<String, Object> message = new HashMap<>();
        List<Persona> personas = (List<Persona>) service.buscarPorApellido(apellido);
        if (personas.isEmpty()) {
            //throw new BadRequestException(String.format("no existen personas con el apellido %s", apellido));
            message.put("succes", Boolean.FALSE);
            message.put("message",String.format("no existen personas con el apellido %s", apellido));
            return ResponseEntity.badRequest().body(message);
        }
        message.put("succes", Boolean.TRUE);
        message.put("datos", personas);
        return ResponseEntity.ok(message);
    }

    @GetMapping("/dni/{dni}")
    public ResponseEntity<?> busarPorDni(@PathVariable String dni){
        Map<String, Object> message = new HashMap<>();
        Optional<Persona> oPersona = service.buscarPorDni(dni);
        if (!oPersona.isPresent()) {
            //throw new BadRequestException(String.format("la persona con dni %s no existe", dni));
            message.put("succes", Boolean.FALSE);
            message.put("message",String.format("la persona con dni %s no existe", dni));
            return ResponseEntity.badRequest().body(message);
        }
        message.put("succes", Boolean.TRUE);
        message.put("datos", oPersona.get());
        return ResponseEntity.ok(message);
    }
}
