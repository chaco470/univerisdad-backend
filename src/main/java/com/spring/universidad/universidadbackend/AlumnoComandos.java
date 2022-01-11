package com.spring.universidad.universidadbackend;

import com.spring.universidad.universidadbackend.modelo.entidades.Alumno;
import com.spring.universidad.universidadbackend.modelo.entidades.Carrera;
import com.spring.universidad.universidadbackend.modelo.entidades.Persona;
import com.spring.universidad.universidadbackend.servicios.contratos.AlumnoDAO;
import com.spring.universidad.universidadbackend.servicios.contratos.CarreraDAO;
import com.spring.universidad.universidadbackend.servicios.contratos.PersonaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AlumnoComandos implements CommandLineRunner {

    @Autowired
    private CarreraDAO carreraDAO;
    @Autowired
    @Qualifier("alumnoDAOImpl")
    private PersonaDAO personaDAO;

    @Override
    public void run(String... args) throws Exception {

        /*Optional<Carrera> ingSistemas = carreraDAO.findById(2);
        Iterable<Persona> alumnos = personaDAO.findAll();

        alumnos.forEach(alumno -> ((Alumno)alumno).setCarrera(ingSistemas.get()));
        alumnos.forEach(alumno -> personaDAO.save(alumno));*/

        /*Optional<Persona> alumno_1 = personaDAO.findById(1);
        Optional<Persona> persona = personaDAO.buscarPorNombreYApellido(alumno_1.get().getNombre(), alumno_1.get().getApellido());
        System.out.println(persona.toString());

        Optional<Persona> personaDNI = personaDAO.buscarPorDni(alumno_1.get().getDni());
        System.out.println(personaDNI.toString());

        Iterable<Persona> personasApellido = personaDAO.buscarPorApellido(alumno_1.get().getApellido());
        personasApellido.forEach(System.out::println);*/

        Optional<Carrera> ingSistemas = carreraDAO.findById(2);
        Iterable<Persona> alumnosIngenieria = ((AlumnoDAO) personaDAO).buscarAlumnoPorNombreCarrera(ingSistemas.get().getNombre());
        alumnosIngenieria.forEach(System.out::println);

    }
}
