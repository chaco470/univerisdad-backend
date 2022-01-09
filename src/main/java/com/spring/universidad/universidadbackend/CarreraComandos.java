package com.spring.universidad.universidadbackend;

import com.spring.universidad.universidadbackend.modelo.entidades.Carrera;
import com.spring.universidad.universidadbackend.servicios.contratos.CarreraDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CarreraComandos implements CommandLineRunner {

    @Autowired
    private CarreraDAO servicio;

    @Override
    public void run(String... args) throws Exception {
        /*Carrera ingenieria = new Carrera(null,"ingenieria en sitemas",20, 5);
        Carrera ingEnSis = servicio.save(ingenieria);
        System.out.println(ingEnSis.toString());*/
    }
}
