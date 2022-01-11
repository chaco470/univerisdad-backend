package com.spring.universidad.universidadbackend;

import com.spring.universidad.universidadbackend.modelo.entidades.Carrera;
import com.spring.universidad.universidadbackend.repositorio.CarreraRepository;
import com.spring.universidad.universidadbackend.servicios.contratos.CarreraDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CarreraComandos implements CommandLineRunner {

    @Autowired
    private CarreraDAO servicio;

    @Override
    public void run(String... args) throws Exception {
        /*
        Carrera ingSistemas = new Carrera(null, "ingenieria en sistemas", 50, 7);
        Carrera ingAlimentos = new Carrera(null, "ingenieria en alimentos", 40, 7);
        Carrera ingElectronica = new Carrera(null, "ingenieria en electronica", 50, 7);
        Carrera ingInformatica = new Carrera(null, "ingenieria en informatica", 50, 7);
        Carrera licSistemas = new Carrera(null, "licenciatura en sistemas", 30, 5);
        Carrera licAlimentos = new Carrera(null, "licenciatura en alimentos", 25, 5);
        Carrera licElectronica = new Carrera(null, "licenciatura en electronica", 30, 5);

        servicio.save(ingSistemas);servicio.save(ingAlimentos);servicio.save(ingElectronica);servicio.save(ingInformatica);
        servicio.save(licSistemas);servicio.save(licAlimentos);servicio.save(licElectronica);*/
        List<Carrera> carreras = (List<Carrera>) servicio.findCarrerasByCantidadAnios(5);
        //carreras.forEach(System.out::println);
    }
}
