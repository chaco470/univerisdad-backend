package com.spring.universidad.universidadbackend.controlador;

import com.spring.universidad.universidadbackend.exception.BadRequestException;
import com.spring.universidad.universidadbackend.modelo.entidades.Persona;
import com.spring.universidad.universidadbackend.servicios.contratos.GenericDAO;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

public class GenericController <E, S extends GenericDAO<E>>{
    protected final S service;
    protected String nombreEntidad;

    public GenericController(S service) {
        this.service = service;
    }

    /*@GetMapping
    public List<E> obtenerTodos(){
        List<E>res = (List<E>)service.findAll();
        if(res.isEmpty()) throw new BadRequestException(String.format("no hay ninguna entidad %ss", nombreEntidad));
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
    */

   @GetMapping
    public ResponseEntity<?> obtenerTodos(){
        Map<String, Object> message = new HashMap<>();
        List<E>res = (List<E>)service.findAll();
        if(res.isEmpty()){
            //throw new BadRequestException(String.format("no hay ninguna entidad %ss", nombreEntidad));
            message.put("succes", Boolean.FALSE);
            message.put("message", String.format("no existe ninguna entidad del tipo %s", nombreEntidad));
            return ResponseEntity.badRequest().body(message);
        }
        message.put("succes", Boolean.TRUE);
        message.put("datos", res);
        return ResponseEntity.ok(message);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPorId(@PathVariable(required = false) Integer id){
        Map<String, Object> message = new HashMap<>();
        Optional<E> res = service.findById(id);
        if(!res.isPresent()){
            //throw new BadRequestException(String.format("no hay ninguna entidad %ss", nombreEntidad));
            message.put("succes", Boolean.FALSE);
            message.put("message", String.format("no existe ninguna entidad con id: %d", id));
            return ResponseEntity.badRequest().body(message);
        }
        message.put("succes", Boolean.TRUE);
        message.put("datos", res.get());
        return ResponseEntity.ok(message);
    }

    /*@PostMapping
    public ResponseEntity<?> altaEntidad(@RequestBody E entidad){
        Map<String, Object> message = new HashMap<>();
        message.put("succes", Boolean.TRUE);
        message.put("datos", service.save(entidad));
        return ResponseEntity.ok(message);
    }*/

    @PostMapping
    public ResponseEntity<?> altaEntidad(@Valid @RequestBody E entidad, BindingResult result){
        Map<String, Object> message = new HashMap<>();
        if (result.hasErrors()){
            result.getFieldErrors()
                    .forEach(fieldError -> message.put(fieldError.getField(), fieldError.getDefaultMessage()));
            return ResponseEntity.badRequest().body(message);
        }
        message.put("succes", Boolean.TRUE);
        message.put("datos", service.save(entidad));
        return ResponseEntity.ok(message);
    }

    @DeleteMapping("/{id}")
    public void eliminarEntidad(@PathVariable Integer id){
        service.deleteById(id);
    }

}
