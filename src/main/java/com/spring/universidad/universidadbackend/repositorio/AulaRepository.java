package com.spring.universidad.universidadbackend.repositorio;

import com.spring.universidad.universidadbackend.modelo.entidades.Aula;
import com.spring.universidad.universidadbackend.modelo.entidades.numeradores.TipoPizzarron;
import org.springframework.data.repository.CrudRepository;

public interface AulaRepository extends CrudRepository<Aula, Integer> {

    Iterable<Aula>findAulaByTipoPizzarron(TipoPizzarron tipoPizzarron);
    Iterable<Aula> findAulaByPabellon_Nombre(String nombrePabellon);
    Iterable<Aula>findAulaByNumeroAula(Integer numeroAula);
}
