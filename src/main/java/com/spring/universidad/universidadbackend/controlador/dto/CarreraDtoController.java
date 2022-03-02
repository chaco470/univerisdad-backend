package com.spring.universidad.universidadbackend.controlador.dto;

import com.spring.universidad.universidadbackend.modelo.dto.CarreraDTO;
import com.spring.universidad.universidadbackend.modelo.entidades.Carrera;
import com.spring.universidad.universidadbackend.modelo.mapper.CarreraMapper;
import com.spring.universidad.universidadbackend.servicios.contratos.CarreraDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/carreras")
@ConditionalOnProperty(prefix = "app", name = "controller.enable-dto", havingValue = "true")
public class CarreraDtoController {

    @Autowired
    private CarreraDAO carreraDAO;

    @GetMapping
    public ResponseEntity<?>GetAll(){
        Map<String, Object> message = new HashMap<>();
        List<Carrera>res = (List<Carrera>)carreraDAO.findAll();

        List<CarreraDTO> carreraDTOS = res
                .stream()
                .map(CarreraMapper::mapCarrera)
                .collect(Collectors.toList());

        message.put("succes", Boolean.TRUE);
        message.put("datos", carreraDTOS);
        return ResponseEntity.ok(message);

    }
}
