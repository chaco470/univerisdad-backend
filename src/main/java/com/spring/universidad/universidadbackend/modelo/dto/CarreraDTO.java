package com.spring.universidad.universidadbackend.modelo.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarreraDTO {

    private Integer codigo;
    private String nombre;
    private Integer cantidad_materias;
    private Integer cantidad_anios;


}
