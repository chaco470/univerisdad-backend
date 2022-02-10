package com.spring.universidad.universidadbackend.controlador;

import com.spring.universidad.universidadbackend.exception.BadRequestException;
import com.spring.universidad.universidadbackend.modelo.entidades.Carrera;
import com.spring.universidad.universidadbackend.servicios.contratos.CarreraDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/carreras")
public class CarreraController extends GenericController<Carrera, CarreraDAO>{


    @Autowired
    public CarreraController(CarreraDAO service) {
        super(service);
        nombreEntidad = "Carrera";
    }

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

    @GetMapping("/nombreCarrera")
    public List<Carrera> findCarrerasByNombreContainsIgnoreCase(@RequestParam String nombreCarrera){
        List<Carrera> carreras = (List<Carrera>) service.findCarrerasByNombreContainsIgnoreCase(nombreCarrera);
        if (carreras.isEmpty()) throw new BadRequestException(String.format("No existen carreras que contengan el nombre %s", nombreCarrera));
        return carreras;
    }

}
