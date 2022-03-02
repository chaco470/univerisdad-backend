package com.spring.universidad.universidadbackend.modelo.mapper;

import com.spring.universidad.universidadbackend.modelo.dto.CarreraDTO;
import com.spring.universidad.universidadbackend.modelo.entidades.Carrera;

public class CarreraMapper {

    public static CarreraDTO mapCarrera(Carrera carrera){
        CarreraDTO carreraDTO = new CarreraDTO();
        carreraDTO.setCodigo(carrera.getId());
        carreraDTO.setNombre(carrera.getNombre());
        carreraDTO.setCantidad_anios(carrera.getCantidadAnios());
        carreraDTO.setCantidad_materias(carrera.getCantidadMaterias());
        return carreraDTO;
    }
}
