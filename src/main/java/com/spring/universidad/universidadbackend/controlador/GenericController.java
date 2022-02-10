package com.spring.universidad.universidadbackend.controlador;

import com.spring.universidad.universidadbackend.exception.BadRequestException;
import com.spring.universidad.universidadbackend.modelo.entidades.Persona;
import com.spring.universidad.universidadbackend.servicios.contratos.GenericDAO;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public class GenericController <E, S extends GenericDAO<E>>{
    protected final S service;
    protected String nombreEntidad;

    public GenericController(S service) {
        this.service = service;
    }

    @GetMapping
    public List<E>obtenerTodos(){
        List<E>res = (List<E>)service.findAll();
        if(res.size()<=0) throw new BadRequestException(String.format("no hay ninguna entidad %ss", nombreEntidad));
        return res ;
    }

    @GetMapping("/{id}")
    public E getPorId(@PathVariable(required = false) Integer id){
        Optional<E> oEntity = service.findById(id);
        if (oEntity.isEmpty()) throw new BadRequestException(String.format("no existe la entidad con id %d", id));
        return oEntity.get();
    }

    @PostMapping
    public E altaEntidad(@RequestBody E entidad){
        return service.save(entidad);
    }

    @DeleteMapping("/{id}")
    public void eliminarEntidad(@PathVariable Integer id){
        service.deleteById(id);
    }
}
