package com.spring.universidad.universidadbackend.controlador;

import com.spring.universidad.universidadbackend.exception.BadRequestException;
import com.spring.universidad.universidadbackend.modelo.entidades.Aula;
import com.spring.universidad.universidadbackend.modelo.entidades.numeradores.TipoPizzarron;
import com.spring.universidad.universidadbackend.servicios.contratos.AulaDAO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public class AulaController extends GenericController <Aula, AulaDAO>{

    public AulaController(AulaDAO service) {
        super(service);
    }

    //findAulasByPizarron, findAulasByPabellonNombre y findAulaByNroAula


    @GetMapping("/{tipoPizzarron}")
    public List<Aula> findAulasByPizarron(@PathVariable TipoPizzarron tipoPizzarron) {
        List<Aula> aulaByTipoPizzarron = (List<Aula>) service.findAulaByTipoPizzarron(tipoPizzarron);
        if (aulaByTipoPizzarron.isEmpty()) throw new BadRequestException(String.format("no existen aulas con pizarrones del tipo %s", tipoPizzarron));
        return aulaByTipoPizzarron;
    }

    @GetMapping("/{numeroAula}")
    public List<Aula> findAulaByNroAula(Integer numeroAula){
        List<Aula> aulaByNumeroAula = (List<Aula>) service.findAulaByNumeroAula(numeroAula);
        if (aulaByNumeroAula.isEmpty()) throw new BadRequestException(String.format("no existen aulas con el numero %d", numeroAula));
        return aulaByNumeroAula;
    }
}
