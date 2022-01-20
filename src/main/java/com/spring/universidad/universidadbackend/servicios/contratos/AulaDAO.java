package com.spring.universidad.universidadbackend.servicios.contratos;

import com.spring.universidad.universidadbackend.modelo.entidades.Aula;
import com.spring.universidad.universidadbackend.modelo.entidades.numeradores.TipoPizzarron;

public interface AulaDAO extends GenericDAO<Aula>{

    Iterable<Aula>findAulaByTipoPizzarron(TipoPizzarron tipoPizzarron);
    Iterable<Aula>findAulaByPabellon_Nombre(String nombrePabellon);
    Iterable<Aula>findAulaByNumeroAula(Integer numeroAula);
}
