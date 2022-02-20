package com.spring.universidad.universidadbackend.controlador;

import com.spring.universidad.universidadbackend.exception.BadRequestException;
import com.spring.universidad.universidadbackend.modelo.entidades.Aula;
import com.spring.universidad.universidadbackend.modelo.entidades.numeradores.TipoPizzarron;
import com.spring.universidad.universidadbackend.servicios.contratos.AulaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/aulas")
public class AulaController extends GenericController <Aula, AulaDAO>{

    @Autowired
    public AulaController(AulaDAO service) {
        super(service);
    }

    @GetMapping("/{tipoPizzarron}")
    public ResponseEntity<?> findAulasByPizarron(@PathVariable TipoPizzarron tipoPizzarron) {
        Map<String, Object> message = new HashMap<>();
        List<Aula> aulaByTipoPizzarron = (List<Aula>) service.findAulaByTipoPizzarron(tipoPizzarron);
        if (aulaByTipoPizzarron.isEmpty()){
            //throw new BadRequestException(String.format("no existen aulas con pizarrones del tipo %s", tipoPizzarron));
            message.put("succes", Boolean.FALSE);
            message.put("message",String.format("no existe ningun aula con pizzarrones de tipo: %s", tipoPizzarron));
            return ResponseEntity.badRequest().body(message);
        }
        message.put("succes", Boolean.TRUE);
        message.put("datos", aulaByTipoPizzarron);
        return ResponseEntity.ok(message);
    }

    @GetMapping("/{numeroAula}")
    public ResponseEntity<?> findAulaByNroAula(Integer numeroAula){
        Map<String, Object> message = new HashMap<>();
        List<Aula> aulaByNumeroAula = (List<Aula>) service.findAulaByNumeroAula(numeroAula);
        if (aulaByNumeroAula.isEmpty()) {
            //throw new BadRequestException(String.format("no existen aulas con el numero %d", numeroAula));
            message.put("succes", Boolean.FALSE);
            message.put("message",String.format("no existe ningun aula con el numero : %d", numeroAula));
            return ResponseEntity.badRequest().body(message);
        }
        message.put("succes", Boolean.TRUE);
        message.put("datos", aulaByNumeroAula);
        return ResponseEntity.ok(message);
    }
}
