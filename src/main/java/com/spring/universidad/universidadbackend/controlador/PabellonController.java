package com.spring.universidad.universidadbackend.controlador;

import com.spring.universidad.universidadbackend.modelo.entidades.Pabellon;
import com.spring.universidad.universidadbackend.servicios.contratos.PabellonDAO;

public class PabellonController extends GenericController<Pabellon, PabellonDAO>{


    public PabellonController(PabellonDAO service) {
        super(service);
    }


}
