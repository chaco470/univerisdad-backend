package com.spring.universidad.universidadbackend.controlador;

import com.spring.universidad.universidadbackend.exception.BadRequestException;
import com.spring.universidad.universidadbackend.modelo.entidades.Persona;
import com.spring.universidad.universidadbackend.servicios.contratos.PersonaDAO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

public class PersonaController extends GenericController<Persona, PersonaDAO>{


    public PersonaController(PersonaDAO service) {
        super(service);
    }

    @GetMapping("/nombre-apellido")
    public Persona buscarPorNombreYApellido(@RequestParam String nombre, @RequestParam String apellido){
        Optional<Persona> oPersona = service.buscarPorNombreYApellido(nombre, apellido);
        if(oPersona.isEmpty()) throw new BadRequestException(String.format("la persona con el nombre %s ni apellido %s no existe", nombre, apellido));
        return oPersona.get();
    }
    @GetMapping("/apellido")
    public List<Persona> buscarPersonaPorApellido(@RequestParam String apellido){
        List<Persona> personas = (List<Persona>) service.buscarPorApellido(apellido);
        if (personas.isEmpty()) throw new BadRequestException(String.format("no existen personas con el apellido %s",apellido));
        return personas;
    }

    @GetMapping("/{dni}")
    public Persona busarPorDni(@PathVariable String dni){
        Optional<Persona> oPersona = service.buscarPorDni(dni);
        if (!oPersona.isPresent()) throw new BadRequestException(String.format("la persona con dni %s no existe",dni));
        return oPersona.get();
    }
}
